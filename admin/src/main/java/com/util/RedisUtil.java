package com.util;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis连接池工具类
 * 
 * @author Administrator
 *
 */
public final class RedisUtil{

    // Redis服务器IP
    private static String ADDR = "127.0.0.1";

    // Redis的端口号
    private static int PORT = 6379;

    // 访问密码
    private static String AUTH = "";

    // 可用连接实例的最大数目，默认值为8；
    // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 1024;

    // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 200;

    // 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 10000;

    private static int TIMEOUT = 10000;

    // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;

    /**
     * 初始化Redis连接池
     */
    static {
        try {
            // 在高版本的jedis
            // jar包，比如2.8.2，我们在使用中发现使用JedisPoolConfig时，没有setMaxActive和setMaxWait属性了，这是因为高版本中官方废弃了此方法，用以下两个属性替换。
            // maxActive ==> maxTotal
            // maxWait ==> maxWaitMillis
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            if (AUTH!=null && AUTH.length()>0)
            	jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
            else 
            	jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Jedis实例
     * 
     * @return
     */
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放jedis资源
     * 
     * @param jedis
     */
    @SuppressWarnings("deprecation")
	public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }
    
    public static boolean exists(String key) {
    	Jedis jedis = getJedis();
    	if (jedis==null || key==null)
    		return false;
    	
    	boolean result = false;
    	byte[] bKey = key.getBytes();
    	try {
    		result = jedis.exists(bKey);
    	} catch (Exception e) {
    		return false;
    	} finally {
    		returnResource(jedis);
    	}
    	return result;
    }
    
	@SuppressWarnings("unchecked")
	public static <T> T getObject(String key) {
    	
    	Jedis jedis = getJedis();
    	if (jedis==null)
    		return null;
    	T result = null;
    	try {
    		byte[] data = jedis.get(key.getBytes());
    		result = (T)SerializeUtil.unserialize(data);
    	} catch (Exception e) {
    		return null;
    	} finally {
    		returnResource(jedis);
    	}
    	return result;
    }
    
	public static <T> boolean setObject(String key, T t) {
		return setObject(key,t,-1);
	}
    public static <T> boolean setObject(String key, T t, int seconds) {
    	Jedis jedis = getJedis();
    	if (jedis==null || key==null || key.length()==0 || t==null)
    		return false;
    	
    	byte[] bKey = key.getBytes();
    	try {
    		if (jedis.exists(bKey)) {
        		jedis.del(bKey);
        	}
    		
    		jedis.set(bKey, SerializeUtil.serialize(t));
    		if (seconds>0) {
    			jedis.expire(bKey, seconds);
    		}
    		
    	} catch (Exception e) {
    		return false;
    	} finally {
    		returnResource(jedis);
    	}
    	return true;
    }
    
    @SuppressWarnings("unchecked")
	public static <T> List<T> getList(String key) {
    	Jedis jedis = getJedis();
    	if (jedis==null)
    		return null;
    	byte[] bKey = key.getBytes();
    	List<T> result = new ArrayList<T>();
    	try {
    		List<byte[]> data = jedis.lrange(bKey, 0, -1);
    		for (byte[] bt : data) {
    			result.add((T)SerializeUtil.unserialize(bt));
    		}
    	} catch (Exception e) {
    		return null;
    	} finally {
    		returnResource(jedis);
    	}
    	return result;
    }
    
    public static <T> boolean setList(String key, List<T> list) {
    	return setList(key,list,-1);
    }

    public static <T> boolean setList(String key, List<T> list, int seconds) {
    	Jedis jedis = getJedis();
    	if (jedis==null || key==null || key.length()==0 || list==null)
    		return false;
    	
    	byte[] bKey = key.getBytes();
    	
    	try {
    		if (jedis.exists(bKey)) {
        		jedis.del(bKey);
        	}
    		for (T t : list) {
    			jedis.rpush(bKey, SerializeUtil.serialize(t));
    		}
    		if (seconds>0) {
    			jedis.expire(bKey, seconds);
    		}
    		
    	} catch (Exception e) {
    		return false;
    	} finally {
    		returnResource(jedis);
    	}
    	return true;
    }
}