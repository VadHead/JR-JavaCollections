package level05;

import java.util.*;

public class task3509 {
	
	public static void main(String[] args) {
	}
	
	public static <T> ArrayList<T> newArrayList(T... t) {
		ArrayList<T> arr = new ArrayList<>(t.length);
		Collections.addAll(arr, t);
		return arr;
	}
	
	public static <T> HashSet<T> newHashSet(T... t) {
		HashSet<T> set = new HashSet<T>(t.length);
		Collections.addAll(set, t);
		return set;
	}
	
	public static <K, V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
		if (keys.size() != values.size()) {
			throw new IllegalArgumentException();
		}
		HashMap<K,V> map = new HashMap<K,V>();
		for (int i = 0; i < keys.size(); i++) {
			map.put(keys.get(i), values.get(i));
		}
		return map;
	}
	
}
