package com.cainiao.exclusive;

import com.cainiao.exclusive.service.IRedisLockService;
import com.cainiao.exclusive.tools.RedisLock;
import org.junit.Test;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.locks.Lock;

/**
 * Created by wangkecheng on 2018/8/2.
 */
public class RedissonTest extends BaseSpringTest {

    @Autowired
    private IRedisLockService redisLockService;

    @Test
    public void getLock1(){
        Lock lock = redisLockService.acquireOrgCodeLock("wangkecheng");
        lock.lock();

        System.out.println("获取锁成功1");
    }

    @Test
    public void getLock2(){
        Lock lock = redisLockService.acquireOrgCodeLock("wangkecheng");
        lock.lock();
        System.out.println("获取锁成功2");
    }
}
