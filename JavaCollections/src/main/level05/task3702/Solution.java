package level05.task3702;

import level05.task3702.female.FemaleFactory;
import level05.task3702.male.MaleFactory;

public class Solution {
	
	public static void main(String[] args) {
		MaleFactory male = new MaleFactory();
		
		Human oldMan = male.getPerson(99);
		System.out.println(oldMan.toString());
		
		Human kidBoy = male.getPerson(4);
		System.out.println(kidBoy.toString());
		
		Human teenagerBoy = male.getPerson(15);
		System.out.println(teenagerBoy.toString());
		
		FemaleFactory female = new FemaleFactory();
		
		Human oldWoman = female.getPerson(99);
		System.out.println(oldWoman.toString());
		
		Human kidGirl = female.getPerson(4);
		System.out.println(kidGirl.toString());
		
		Human teenagerGirl = female.getPerson(15);
		System.out.println(teenagerGirl.toString());
		
		AbstractFactory factory = FactoryProducer.getFactory(FactoryProducer.HumanFactoryType.FEMALE);
		System.out.println(factory.getPerson(4));
		
	}
	
}
