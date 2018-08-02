package com.cainiao.exclusive.service;

import com.cainiao.exclusive.tools.RedisLock;
import org.redisson.api.RLock;

public interface IRedisLockService {

	RedisLock acquireOrgCodeWriteoffLock(String lockKey);

	RLock acquireOrgCodeLock(String lockKey);

	void releaseOrgCodeWriteoffLock(String lockKey, RedisLock lock);

	void releaseOrgCodeLock(String lockKey, RLock lock);
}
