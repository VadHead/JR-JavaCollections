package level02.task3206;

import java.lang.reflect.Proxy;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		test(solution.getProxy(Item.class));                        //true false false
		test(solution.getProxy(Item.class, Small.class));           //true false true
		test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
		test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
		test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
	}
	
	
	private static void test(Object proxy) {
		boolean isItem = proxy instanceof Item;
		boolean isBig = proxy instanceof Big;
		boolean isSmall = proxy instanceof Small;
		
		System.out.format("%b %b %b\n", isItem, isBig, isSmall);
	}
	
	public <T extends Item> T getProxy(Class<T> type, Class<?>... addInterfaces) {
		Class<?>[] interfaces = new Class<?>[addInterfaces.length + 1];
		interfaces[0] = type;
		System.arraycopy(addInterfaces, 0, interfaces, 1, addInterfaces.length);
		ItemInvocationHandler handler = new ItemInvocationHandler();
		Object instance = Proxy.newProxyInstance(this.getClass().getClassLoader(), interfaces, handler);
		return (T) instance;
	}
}
