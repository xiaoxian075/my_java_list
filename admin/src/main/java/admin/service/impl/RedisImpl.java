package admin.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class RedisImpl<K,T> {
	@Autowired
    private RedisTemplate<String, Serializable> template;
	
	
	/**   
	 * 缓存基本的对象，Integer、String、实体类等  
	 * @param key 缓存的键值   
	 * @param value 缓存的值   
	 * @return  缓存的对象   
	 */ 
	public boolean setCacheObject(String key,T value)  {
		return setCacheObject(key, value, -1);
	}
	public boolean setCacheObject(String key, T value, long timeout)  {
		return setCacheObject(key, value, timeout, TimeUnit.SECONDS);
	}
	public boolean setCacheObject(String key,T value, long timeout, TimeUnit unit)  {
		ValueOperations<String, Serializable> operation = template.opsForValue();
		operation.set(key, (Serializable)value);
		
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
	public T getCacheObject(String key)  {  
		return (T)template.opsForValue().get(key); 
	}

	/**   
	 * 缓存List数据   
	 * @param key  缓存的键值   
	 * @param dataList 待缓存的List数据   
	 * @return   缓存的对象  
	  */  
	public boolean setCacheList(String key,List<T> dataList)  {
		return setCacheList(key,dataList,-1);
	}
	public boolean setCacheList(String key,List<T> dataList, long timeout)  {
		return setCacheList(key, dataList, timeout, TimeUnit.SECONDS);
	}
	public boolean setCacheList(String key,List<T> dataList, long timeout, TimeUnit unit)  {  
		if (dataList==null) {
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
	public List<T> getCacheList(String key)  { 
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
	public boolean setCacheSet(String key,Set<T> dataSet)  {
		return setCacheSet(key,dataSet,-1);
	}
	public boolean setCacheSet(String key,Set<T> dataSet, long timeout)  {
		return setCacheSet(key, dataSet, timeout, TimeUnit.SECONDS);
	}
	public boolean setCacheSet(String key,Set<T> dataSet, long timeout, TimeUnit unit)  { 
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
	public Set<T> getCacheSet(String key)  {   
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
	public boolean setCacheMap(String key,Map<K,T> dataMap)  {
		return setCacheMap(key,dataMap,-1);
	}
	public boolean setCacheMap(String key,Map<K,T> dataMap, long timeout)  {
		return setCacheMap(key, dataMap, timeout, TimeUnit.SECONDS);
	}
	public boolean setCacheMap(String key,Map<K,T> dataMap, long timeout, TimeUnit unit)  {
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
	public Map<K,T> getCacheMap(String key)  {  

		Map<Object, Object> map = template.opsForHash().entries(key);
		Map<K,T> result = new HashMap<K,T>();
		for (Entry<Object,Object> entry : map.entrySet()) {
			result.put((K)entry.getKey(), (T)entry.getValue());
		}
		return result;  
	}  
}
