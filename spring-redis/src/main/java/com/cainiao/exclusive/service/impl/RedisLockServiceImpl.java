package com.cainiao.exclusive.service.impl;

import com.cainiao.exclusive.service.IRedisLockService;
import com.cainiao.exclusive.tools.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisLockServiceImpl implements IRedisLockService {

	@Value("${redis_lock_masterName}")
	private String redis_lock_masterName;
	@Value("${redis_lock_url1}")
	private String redis_lock_url1;
	@Value("${redis_lock_url2}")
	private String redis_lock_url2;
	@Value("${redis_lock_timeout}")
	private int redis_lock_timeout;
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	/**缴费单位对应的redis锁集合**/
	Map<String, RedisLock> orgCodeWriteOffLockMap = new ConcurrentHashMap<String, RedisLock>();
	
	/**第三方提供的缴费单位对应的redis锁集合**/
	Map<String, RLock> orgCodeLockMap = new ConcurrentHashMap<String, RLock>();
	
	/**redissson客户端**/
	private RedissonClient redissonClient;
	@PostConstruct
	private void initService(){
		Config config = new Config();
		config.useSentinelServers()
		    .setMasterName(redis_lock_masterName)		    
		    .addSentinelAddress(redis_lock_url1, redis_lock_url2)
                .setMasterConnectionMinimumIdleSize(1)
                .setMasterConnectionPoolSize(3)
		    .setDatabase(15)
		    .setTimeout(redis_lock_timeout);
		redissonClient = Redisson.create(config);
		log.info("RedissonClient初始化完成，连接信息是：masterName:{},sentinelAdderss1:{},sentinelAdderss2:{},Database:{},Timeout:{}",redis_lock_masterName,redis_lock_url1,redis_lock_url2,15,redis_lock_timeout);
	}
	
	@Override
	public RedisLock acquireOrgCodeWriteoffLock(String lockKey){
		RedisLock lock = orgCodeWriteOffLockMap.get(lockKey);
		if(lock == null){
			lock = new RedisLock(redisTemplate, lockKey, 10*1000, 60*1000);
			orgCodeWriteOffLockMap.put(lockKey, lock);
		}
		 
		try {
			if(lock.lock()){
				return lock;
			}else{
				return null;
			}
		} catch (InterruptedException e) {
			log.error("获取锁失败:{}",lockKey);
			Thread.currentThread().interrupt();
			return null;
		}
	}

	@Override
	public void releaseOrgCodeWriteoffLock(String lockKey, RedisLock lock){
		try{
			lock.unlock();
		}catch(Exception e){
			log.error("释放对应的redis锁发生异常，异常信息是：", e);
			orgCodeWriteOffLockMap.put(lockKey, new RedisLock(redisTemplate, lockKey, 10*1000, 60*1000));
		}
		
	}

	/**RedLock获取锁**/
	@Override
	public RLock acquireOrgCodeLock(String lockKey){
		try {
			if(null == orgCodeLockMap.get(lockKey)){
				orgCodeLockMap.put(lockKey, redissonClient.getLock(lockKey));
			}
			RLock lock = orgCodeLockMap.get(lockKey);
			//获取锁的时间给予5秒钟，锁超时时间设置为10秒钟
			if(lock.tryLock(5, 10000000, TimeUnit.SECONDS)){
				return lock;
			}else{
				log.warn("在5秒内获取redis锁失败！");
				return null;
			}
		} catch (InterruptedException e) {
			log.error("获取redis锁异常",e);
			Thread.currentThread().interrupt();
			return null;
		}
	}

	/**RedLock释放锁**/
	@Override
	public void releaseOrgCodeLock(String lockKey, RLock lock){
		try{
			if(lock != null){
				lock.unlock();
			}
		}catch(Exception e){
			log.error("释放对应的redis锁发生异常，异常信息是：", e);
			orgCodeLockMap.put(lockKey, redissonClient.getLock(lockKey));
		}
	}
}
