package level04.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
	
	private Map<Long,SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();
	
	public AnyObject get(Long key) {
		if (!cacheMap.containsKey(key)) {
			return null;
		}else {
			SoftReference<AnyObject> softReference = cacheMap.get(key);
			
			return softReference.get();
		}
	}
	
	public AnyObject put(Long key, AnyObject value) {
		if (!cacheMap.containsKey(key)) {
			SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
			if (softReference != null) {
				softReference.clear();
			}
			return null;
		}else {
			SoftReference<AnyObject> softReferenceOld = cacheMap.get(key);
			SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
			if (softReference != null) {
				softReference.clear();
			}
			return softReferenceOld.get();
		}
		
	}
	
	public AnyObject remove(Long key) {
		if (!cacheMap.containsKey(key)) {
			return null;
		}
		else {
			SoftReference<AnyObject> softReferenceOld = cacheMap.get(key);
			SoftReference<AnyObject> softReference = cacheMap.remove(key);
			softReference.clear();
			return softReferenceOld.get();
			
		}
	}
	
}
