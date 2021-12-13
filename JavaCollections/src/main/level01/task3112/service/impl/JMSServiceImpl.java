package level01.task3112.service.impl;

import level01.task3112.service.Service;

public class JMSServiceImpl implements Service {
	
	@Override
	public void execute() {
		System.out.println("Executing the JMSService");
	}
	
	@Override
	public String getName() {
		return "JMSService";
	}
}
