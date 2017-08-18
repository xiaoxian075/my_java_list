package com.util;

import com.util.RedisUtil;

import redis.clients.jedis.Jedis;

public class JedisObj implements AutoCloseable{
	
	private Jedis jedis;
	
	public JedisObj() {
		jedis = RedisUtil.getJedis();
	}
	
	public Jedis get() {
		return jedis;
	}

	@Override
	public void close() throws Exception {
		if (jedis!=null) {
			RedisUtil.returnResource(jedis);
			jedis = null;
		}
		
	}

}

