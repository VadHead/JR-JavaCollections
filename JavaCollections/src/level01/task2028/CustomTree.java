package level01.task2028;

import java.io.Serializable;
import java.util.*;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
	
	Entry<String> root;
	int size;
	
	public CustomTree() {
		this.root = new Entry<String>("root");
	}
	
	static class Entry<T> implements Serializable {
		
		String elementName;
		boolean availableToAddLeftChildren;
		boolean availableToAddRightChildren;
		Entry<T> parent;
		Entry<T> leftChild;
		Entry<T> rightChild;
		
		public Entry(String elementName) {
			this.elementName = elementName;
			this.availableToAddLeftChildren = true;
			this.availableToAddRightChildren = true;
		}
		
		public boolean isAvailableToAddChildren() {
			return availableToAddLeftChildren || availableToAddRightChildren;
		}
		
	}
	
	@Override
	public boolean add(String s) {
		if (s == null) {
			return false;
		}
		Queue<Entry<String>> queue = new LinkedList<>();
		queue.add(root);
		Entry<String> e;
		while (true) {
			e = queue.poll();
			if (e != null && e.elementName == null) {
				e.elementName = s;
				size++;
				return true;
			}
			else if (e != null && e.availableToAddLeftChildren) {
				e.availableToAddLeftChildren = false;
				e.leftChild = new Entry<>(s);
				e.leftChild.parent = e;
				size++;
				return true;
			}
			else if (e != null && e.availableToAddRightChildren) {
				e.availableToAddRightChildren = false;
				e.rightChild = new Entry<>(s);
				e.rightChild.parent = e;
				size++;
				return true;
			}
			else {
				if (e != null) {
					queue.add(e.leftChild);
					queue.add(e.rightChild);
				}
			}
		}
	}
	
	public String getParent(String s) {
		if (s == null) {
			return null;
		}
		Queue<Entry<String>> queue = new LinkedList<>();
		queue.add(root);
		Entry<String> e;
		while (true) {
			e = queue.poll();
			if (e == null) {
				return null;
			}
//			if (e.elementName != null && e.elementName.equals(s)) {
//				return e.parent.elementName;
//			}
			 if (e.leftChild != null && e.leftChild.elementName.equals(s)) {
				return e.elementName;
			}
			else if (e.rightChild != null && e.rightChild.elementName.equals(s)) {
				return e.elementName;
			}
			else {
				if (e.leftChild != null) {
					queue.add(e.leftChild);
				}
				if (e.rightChild != null) {
					queue.add(e.rightChild);
				}
			}
		}
	}
	
	private boolean removeRecursive(Entry<String> e) {
		this.size--;
		//System.out.println("Name: " + e.elementName + " > size:" + size);
		boolean hasLeftChild = !e.availableToAddLeftChildren;
		boolean hasRightChild = !e.availableToAddRightChildren;
		while (hasLeftChild || hasRightChild) {
			if (hasLeftChild) {
				hasLeftChild = removeRecursive(e.leftChild);
			} if (hasRightChild) {
				hasRightChild = removeRecursive(e.rightChild);
			}
		}
		return false;
	}
	
	@Override
	public boolean remove(Object o) {
		if (!(o instanceof String)) {
			throw new UnsupportedOperationException();
		}
		Queue<Entry<String>> queue = new LinkedList<>();
		queue.add(root);
		Entry<String> e;
		while (true) {
			e = queue.poll();
			if (e == null) {
				return false;
			}
			if (e.leftChild != null && e.leftChild.elementName.equals(o)) {
				removeRecursive(e.leftChild);
				e.leftChild = null;
				e.availableToAddLeftChildren = true;
				return true;
			}
			else if (e.rightChild != null && e.rightChild.elementName.equals(o)) {
				removeRecursive(e.rightChild);
				e.rightChild = null;
				e.availableToAddRightChildren = true;
				return true;
			}
			else {
				if (e.leftChild != null) {
					queue.add(e.leftChild);
				}
				if (e.rightChild != null) {
					queue.add(e.rightChild);
				}
			}
		}
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public String get(int index) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String set(int index, String element) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void add(int index, String element) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String remove(int index) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends String> c) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public List<String> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}
	
}
