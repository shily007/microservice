package com.dy.redis;
//package com.sc.redis;
//
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import io.rebloom.client.Client;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//import redis.clients.util.Pool;
//
///**
// * 基于redis的布隆过滤器工具类
// * 
// * @author dy
// * 2020年7月13日
// */
//@Component
//public class RebloomUtil {
//
//	@Autowired
//	private RedisProperties redisProperties;
//
//	public Client createClient() {
//		JedisPoolConfig conf = new JedisPoolConfig();
//		conf.setMaxTotal(100);
//		conf.setTestOnBorrow(false);
//		conf.setTestOnReturn(false);
//		conf.setTestOnCreate(false);
//		conf.setTestWhileIdle(false);
//		conf.setMinEvictableIdleTimeMillis(60000);
//		conf.setTimeBetweenEvictionRunsMillis(30000);
//		conf.setNumTestsPerEvictionRun(-1);
//		conf.setFairness(true);
//		Pool<Jedis> pool = null;
//		if (StringUtils.isNotBlank(redisProperties.getPassword())) {
//			pool = new JedisPool(conf, redisProperties.getHost(), redisProperties.getPort(), 500,
//					redisProperties.getPassword(), true);
//		} else {
//			pool = new JedisPool(conf, redisProperties.getHost(), redisProperties.getPort(), 500);
//		}
//		return new Client(pool);
//	}
//	
//	/**
//	 * 创建过滤器
//	 * createFilter
//	 * @param <T>
//	 * @param clazz
//	 * @param pre 
//	 * @param initCapacity 数量
//	 * @param errorRate 错判率
//	 * @author dy
//	 * 2020年7月13日
//	 */
//	public <T> void createFilter(Class<T> clazz,String pre,long initCapacity,double errorRate) {
//		Client client = createClient();		
//		if (client != null) {
//			client.createFilter(getRebloomKey(clazz, pre), initCapacity, errorRate);
//			client.close();
//		}
//	}
//	
//	/**
//	 * 向过滤器添加数据
//	 * name
//	 * @param <T>
//	 * @param clazz
//	 * @param pre
//	 * @param id
//	 * @return
//	 * @author dy
//	 * 2020年7月13日
//	 */
//	public <T> boolean add(Class<T> clazz,String pre,String id) {
//		Client client = createClient();		
//		if (client != null) {
//			boolean add = client.add(getRebloomKey(clazz, pre), id);
//			client.close();
//			if(add) {
//				return true;
//			}			
//		}
//		return false;
//	}
//	
//	/**
//	 * 批量添加
//	 * add
//	 * @param <T>
//	 * @param clazz
//	 * @param pre
//	 * @param ids
//	 * @return
//	 * @author dy
//	 * 2020年7月13日
//	 */
//	public <T> boolean[] add(Class<T> clazz,String pre,String[] ids) {
//		Client client = createClient();		
//		if (client != null) {
//			boolean[] results = client.addMulti(getRebloomKey(clazz, pre), ids);
//			client.close();
//			return results;		
//		}
//		return new boolean[ids.length];
//	}
//	
//	/**
//	 * 查询id是否存在
//	 * exists
//	 * @param <T>
//	 * @param clazz
//	 * @param pre
//	 * @param id
//	 * @return
//	 * @author dy
//	 * 2020年7月13日
//	 */
//	public <T> boolean exists(Class<T> clazz,String pre,String id) {
//		String key = getRebloomKey(clazz, pre);
//		Client client = createClient();
//		if (client != null) {
//			boolean exists = client.exists(key, id);
//			client.close();
//			return exists;			
//		}
//		return false;
//	}
//	
//	public <T> boolean[] exists(Class<T> clazz,String pre,String[] ids) {
//		String key = getRebloomKey(clazz, pre);
//		Client client = createClient();
//		if (client != null) {
//			boolean[] exists = client.existsMulti(key, ids);
//			client.close();
//			return exists;		
//		}
//		return new boolean[ids.length];
//	}
//	
//	/**
//	 * 根据类的class获取rebloom中的key
//	 * getRebloomKey
//	 * @param clazz 类的class
//	 * @param pre 前缀
//	 * @return
//	 * @author dy
//	 * 2020年7月9日
//	 */
//	public String getRebloomKey(Class<?> clazz,String pre) {	
//		return pre + clazz.getSimpleName();
//	}
//
//}
