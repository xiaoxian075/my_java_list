package com.cache.redis;

import java.io.Serializable;

import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class Redis {
	private JedisConnectionFactory connectionFactory;
	private RedisTemplate<Serializable, Serializable> redisOperations;
	private RedisCacheManager redisCacheManager;
	public JedisConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}
	public void setConnectionFactory(JedisConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}
	public RedisTemplate<Serializable, Serializable> getRedisOperations() {
		return redisOperations;
	}
	public void setRedisOperations(RedisTemplate<Serializable, Serializable> redisOperations) {
		this.redisOperations = redisOperations;
	}
	public RedisCacheManager getRedisCacheManager() {
		return redisCacheManager;
	}
	public void setRedisCacheManager(RedisCacheManager redisCacheManager) {
		this.redisCacheManager = redisCacheManager;
	}
}
