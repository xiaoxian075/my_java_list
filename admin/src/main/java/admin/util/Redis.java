package admin.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public interface Redis<K,T> {
	
	
	/**   
	 * 缓存基本的对象，Integer、String、实体类等  
	 * @param key 缓存的键值   
	 * @param value 缓存的值   
	 * @return  缓存的对象   
	 */ 
	public boolean setCacheObject(String key,T value);
	public boolean setCacheObject(String key, T value, long timeout);
	public boolean setCacheObject(String key,T value, long timeout, TimeUnit unit);     
	
	/**   
	 * 获得缓存的基本对象。   
	 * @param key  缓存键值   
	 * @param operation   
	 * @return   缓存键值对应的数据   
	 */
	public T getCacheObject(String key);

	/**   
	 * 缓存List数据   
	 * @param key  缓存的键值   
	 * @param dataList 待缓存的List数据   
	 * @return   缓存的对象  
	  */  
	public boolean setCacheList(String key,List<T> dataList);
	public boolean setCacheList(String key,List<T> dataList, long timeout);
	public boolean setCacheList(String key,List<T> dataList, long timeout, TimeUnit unit);    
	
	/**   
	 * 获得缓存的list对象  
	 * @param key 缓存的键值   
	 * @return  缓存键值对应的数据   
	 */
	public List<T> getCacheList(String key);     
	
	/**   
	 * 缓存Set   
	 * @param key  缓存键值   
	 * @param dataSet 缓存的数据   
	 * @return   缓存数据的对象   
	 */ 
	public boolean setCacheSet(String key,Set<T> dataSet);
	public boolean setCacheSet(String key,Set<T> dataSet, long timeout);
	public boolean setCacheSet(String key,Set<T> dataSet, long timeout, TimeUnit unit);   
	
	/**   
	 * 获得缓存的set   
	 * @param key   
	 * @param operation   
	 * @return   
	 */
	public Set<T> getCacheSet(String key);   
	
	/**   
	 * 缓存Map   
	 * @param key   
	 * @param dataMap   
	 * @return   
	 */  
	public boolean setCacheMap(String key,Map<K,T> dataMap);
	public boolean setCacheMap(String key,Map<K,T> dataMap, long timeout);
	public boolean setCacheMap(String key,Map<K,T> dataMap, long timeout, TimeUnit unit);    
	
	/**   
	 * 获得缓存的Map   
	 * @param key   
	 * @param hashOperation   
	 * @return   
	 */ 
	public Map<K,T> getCacheMap(String key);
}
