package level05.task3510;

public class Kitten extends Cat {
	
	public Kitten(String name) {
		super(name);
	}
	
	@Override
	public String toString() {
		return "Котенок " + name;
	}
	
}
