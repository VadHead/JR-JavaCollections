package level01.task3112.service.impl;

import level01.task3112.service.Service;

public class EJBServiceImpl implements Service {
	
	@Override
	public void execute() {
		System.out.println("Executing the EJBService");
	}
	
	@Override
	public String getName() {
		return "EJBService";
	}
}
