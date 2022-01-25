package level05.task3702;

import level05.task3702.female.FemaleFactory;
import level05.task3702.male.MaleFactory;


public class FactoryProducer {
	
	public static AbstractFactory getFactory(HumanFactoryType type) {
		if (type == HumanFactoryType.MALE) {
			return new MaleFactory();
		}
		return new FemaleFactory();
		
	}
	
	public static enum HumanFactoryType {
		MALE,
		FEMALE
	}
	
}
