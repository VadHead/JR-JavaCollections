package level05.task3512;

public class Generator<T> {
	
	Class<T> tClass;
	
	public Generator(Class<T> tClass) {
		this.tClass = tClass;
	}
	
	T newInstance()
			throws InstantiationException, IllegalAccessException {
		return tClass.newInstance();
	}
	
}
