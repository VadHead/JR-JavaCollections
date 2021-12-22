package level04.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
	
	private static final Object PRESENT = new Object();
	private transient HashMap<E,Object> map;
	
	public AmigoSet(Collection<? extends E> collection) {
		this.map = new HashMap<>(Math.max((int) (collection.size() / .75f) + 1, 16));
		addAll(collection);
	}
	
	public AmigoSet() {
		this.map = new HashMap<>();
	}
	
	@Override
	public Iterator iterator() {
		return map.keySet().iterator();
	}
	
	@Override
	public boolean add(E e) {
		return map.put(e, PRESENT) == null;
	}
	
	@Override
	public boolean addAll(Collection c) {
		return false;
	}
	
	@Override
	public Object[] toArray(Object[] a) {
		return new Object[0];
	}
	
	@Override
	public int size() {
		return map.size();
	}
	
	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}
	
	@Override
	public boolean contains(Object o) {
		return super.contains(o);
	}
	
	@Override
	public void clear() {
		map.clear();
	}
	
	@Override
	public boolean remove(Object o) {
		return super.remove(o);
	}
	
	@Override
	public Object clone() {
		try {
			AmigoSet<E> newSet = (AmigoSet<E>) super.clone();
			newSet.map = (HashMap<E, Object>) map.clone();
			return newSet;
		} catch (Exception e) {
			throw new InternalError();
		}
	}
	
}
