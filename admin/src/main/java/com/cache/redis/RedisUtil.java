package com.cache.redis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public final class RedisUtil {

	private static RedisTemplate<String, Serializable> template = null;

	public static void setTemplate(RedisTemplate<String, Serializable> _template) {
		template = _template;
		
	} 
	
	
	/**   
	 * 缓存基本的对象，Integer、String、实体类等  
	 * @param key 缓存的键值   
	 * @param value 缓存的值   
	 * @return  缓存的对象   
	 */ 
	public static <T> boolean setCacheObject(String key,T t,Class<T> c)  {
		return setCacheObject(key,t,c,-1);
	}
	public static <T> boolean setCacheObject(String key,T t,Class<T> c, long timeout)  {
		return setCacheObject(key,t,c, timeout, TimeUnit.SECONDS);
	}
	public static <T> boolean setCacheObject(String key,T t,Class<T> c, long timeout, TimeUnit unit)  {
		if (!Serializable.class.isAssignableFrom(c)){
			return false;
		}
		
		ValueOperations<String,Serializable> operation = template.opsForValue();
		operation.set(key, (Serializable)t);
		
		if (timeout!=-1) {
			template.expire(key, timeout, unit);
		}
		
		return true;
	}     
	
	/**   
	 * 获得缓存的基本对象。   
	 * @param key  缓存键值   
	 * @param operation   
	 * @return   缓存键值对应的数据   
	 */ 
	@SuppressWarnings("unchecked")
	public static <T> T getCacheObject(String key,Class<T> c)  {  
		if (!Serializable.class.isAssignableFrom(c)){
			return null;
		}
		return (T)template.opsForValue().get(key); 
	}

	/**   
	 * 缓存List数据   
	 * @param key  缓存的键值   
	 * @param dataList 待缓存的List数据   
	 * @return   缓存的对象  
	  */  
	public static <T> boolean setCacheList(String key,List<T> dataList,Class<T> c)  {
		return setCacheList(key,dataList,c,-1);
	}
	public static <T> boolean setCacheList(String key,List<T> dataList,Class<T> c, long timeout)  {
		return setCacheList(key, dataList,c, timeout, TimeUnit.SECONDS);
	}
	public static <T> boolean setCacheList(String key,List<T> dataList,Class<T> c, long timeout, TimeUnit unit)  {  
		if (dataList==null) {
			return false;
		}
		if (!Serializable.class.isAssignableFrom(c)){
			return false;
		}
		ListOperations<String, Serializable> listOperation = template.opsForList();      
		for (T t : dataList) {
			listOperation.rightPush(key,(Serializable) t); 
		}   
		
		if (timeout!=-1) {
			template.expire(key, timeout, unit);
		}
		
		return true;  
	}     
	
	/**   
	 * 获得缓存的list对象  
	 * @param key 缓存的键值   
	 * @return  缓存键值对应的数据   
	 */  
	@SuppressWarnings("unchecked")
	public static <T> List<T> getCacheList(String key,Class<T> c)  {
		if (!Serializable.class.isAssignableFrom(c)){
			return new ArrayList<T>();
		}  
		List<T> dataList = new ArrayList<T>();   
		ListOperations<String,Serializable> listOperation = template.opsForList();   
		Long size = listOperation.size(key);       
		for(int i = 0 ; i < size ; i ++)   {    
			dataList.add((T)listOperation.leftPop(key));   
		}       
		
		return dataList;  
	}     
	
	/**   
	 * 缓存Set   
	 * @param key  缓存键值   
	 * @param dataSet 缓存的数据   
	 * @return   缓存数据的对象   
	 */ 
	public static <T> boolean setCacheSet(String key,Set<T> dataSet,Class<T> c)  {
		return setCacheSet(key,dataSet,c,-1);
	}
	public static <T> boolean setCacheSet(String key,Set<T> dataSet,Class<T> c, long timeout)  {
		return setCacheSet(key, dataSet,c, timeout, TimeUnit.SECONDS);
	}
	public static <T> boolean setCacheSet(String key,Set<T> dataSet,Class<T> c, long timeout, TimeUnit unit)  { 
		if (!Serializable.class.isAssignableFrom(c)){
			return false;
		}
		
		BoundSetOperations<String,Serializable> setOperation = template.boundSetOps(key);              
		Iterator<T> it = dataSet.iterator();   
		while(it.hasNext())   {    
			setOperation.add((Serializable)it.next());   
		}    
		
		if (timeout!=-1) {
			template.expire(key, timeout, unit);
		}
		
		return true;  
	}     
	
	/**   
	 * 获得缓存的set   
	 * @param key   
	 * @param operation   
	 * @return   
	 */  
	@SuppressWarnings("unchecked")
	public static <T> Set<T> getCacheSet(String key,Class<T> c)  {   
		if (!Serializable.class.isAssignableFrom(c)){
			return new HashSet<T>();
		}
		
		Set<T> dataSet = new HashSet<T>();   
		BoundSetOperations<String,Serializable> operation = template.boundSetOps(key);        
		Long size = operation.size();   
		for(int i = 0 ; i < size ; i++)   {    
			dataSet.add((T)operation.pop());  
		}   
		return dataSet;  
	}    
	
	/**   
	 * 缓存Map   
	 * @param key   
	 * @param dataMap   
	 * @return   
	 */  
	public static <K,T> boolean setCacheMap(String key,Map<K,T> dataMap,Class<K> ck,Class<T> ct)  {
		return setCacheMap(key,dataMap,ck,ct,-1);
	}
	public static <K,T> boolean setCacheMap(String key,Map<K,T> dataMap,Class<K> ck,Class<T> ct, long timeout)  {
		return setCacheMap(key, dataMap,ck,ct, timeout, TimeUnit.SECONDS);
	}
	public static <K,T> boolean setCacheMap(String key,Map<K,T> dataMap,Class<K> ck,Class<T> ct, long timeout, TimeUnit unit)  {
		if (!Serializable.class.isAssignableFrom(ck)){
			return false;
		}
		if (!Serializable.class.isAssignableFrom(ct)){
			return false;
		}
		
		HashOperations<String, K, T> hashOperations = template.opsForHash();   
		if(null != dataMap)   {         
			for (Map.Entry<K, T> entry : dataMap.entrySet()) {
				hashOperations.put(key,entry.getKey(),entry.getValue());    
			}         
		}    
		
		if (timeout!=-1) {
			template.expire(key, timeout, unit);
		}
		
		return true;  
	}     
	
	/**   
	 * 获得缓存的Map   
	 * @param key   
	 * @param hashOperation   
	 * @return   
	 */  
	@SuppressWarnings("unchecked")
	public static <K,T> Map<K,T> getCacheMap(String key,Class<K> ck,Class<T> ct)  {  
		if (!Serializable.class.isAssignableFrom(ck)){
			return new HashMap<K,T>();
		}
		if (!Serializable.class.isAssignableFrom(ct)){
			return new HashMap<K,T>();
		}
		
		Map<Object, Object> map = template.opsForHash().entries(key);
		Map<K,T> result = new HashMap<K,T>();
		for (Entry<Object,Object> entry : map.entrySet()) {
			result.put((K)entry.getKey(), (T)entry.getValue());
		}
		return result;  
	}                       	
}
