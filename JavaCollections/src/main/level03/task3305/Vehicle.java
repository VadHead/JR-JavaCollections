package level03.task3305;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "className")
public class Vehicle {
	protected String name;
	protected String owner;
	protected int age;
}
