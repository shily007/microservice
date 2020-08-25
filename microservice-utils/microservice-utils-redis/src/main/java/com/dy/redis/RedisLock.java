package com.dy.redis;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

/**
 * redis分布式锁
 * 
 * @author dy 2020年8月25日
 */
@Component
public class RedisLock {

	/**
	 * 锁默认前缀
	 */
	private static final String DEFAULT_LOCK_PREFIX = "LOCK:";
	/**
	 * 锁默认过期时间，默认 5 分钟
	 */
	private static final long DEFAULT_EXPIRE = 5*60L;
	/**
	 * 锁默认过期时间单位
	 */
	private static final TimeUnit DEFAULT_UNIT = TimeUnit.SECONDS;
	/**
	 * 与 Redis 进行交互
	 */
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public boolean tryLock(String key, String value) {
		return tryLock(key, value, DEFAULT_EXPIRE, DEFAULT_UNIT);
	}

	/**
	 * 尝试获取锁 tryLock
	 * 
	 * @param key    键
	 * @param value  值
	 * @param expire 过期时间
	 * @param unit   过期时间单位
	 * @return
	 * @author dy 2020年8月25日
	 */
	public boolean tryLock(String key, String value, long expire, TimeUnit unit) {
		String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return 'OK' "
				+ "else return redis.call('set', KEYS[1], ARGV[1],'EX',ARGV[2],'NX') end";	
		RedisScript<String> redisScript = new DefaultRedisScript<String>(script,String.class);
		String result = redisTemplate.execute(redisScript, key2Keys(key), value, String.valueOf(expire));
		return "OK".equals(result);
		
//		String evalScript = new StringBuilder()
//                .append(" if redis.call('setnx', KEYS[1], ARGV[1])==1 then")
//                .append("   if redis.call('get', KEYS[1])==ARGV[1] then")
//                .append("       return redis.call('expire', KEYS[1], ARGV[2])")
//                .append("   else return 0")
//                .append("   end")
//                .append(" else return 0")
//                .append(" end").toString();
//        RedisScript<Long> redisScript = new DefaultRedisScript<Long>(evalScript, Long.class);
//        Long result = redisTemplate.execute(redisScript, Arrays.asList(key), String.valueOf(value), String.valueOf(60));
//        if (result == 1) {
//            // 获取锁成功
//            return true;
//        } else {
//            return false;
//        }
	}

	/**
	 * 释放锁 release
	 * 
	 * @param key   键
	 * @param value 值
	 * @return
	 * @author dy 2020年8月25日
	 */
	public boolean release(String key, String value) {
		String script = "if redis.call('get', KEYS[1]) == ARGV[1] then "
				+ "redis.call('del', KEYS[1]) return 1 else return 0 end";
		RedisScript<Long> redisScript = new DefaultRedisScript<Long>(script, Long.class);
		Long result = redisTemplate.execute(redisScript, key2Keys(key), value);
		return result != null && result > 0;
	}

	/**
	 * 将key转为集合 key2Keys
	 * 
	 * @param key
	 * @return
	 * @author dy 2020年8月25日
	 */
	private List<String> key2Keys(String key) {
		return Arrays.asList(DEFAULT_LOCK_PREFIX + key);
	}

}
