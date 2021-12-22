package level04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class task3412 {
	
	private static final Logger logger = LoggerFactory.getLogger(task3412.class);
	
	private int value1;
	private String value2;
	private Date value3;
	
	public task3412(int value1, String value2, Date value3) {
		logger.debug("Constructor: this.value1 = " + value1 + "this.value = " + value2 + "this.value3 = " + value3);
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
	}
	
	public static void main(String[] args) {
		logger.info("app starting");
		task3412 task = new task3412(13, "march", new Date());
		task.divide(1,0);
		task.printDateAsLong();
		task.printString();
		
	}
	
	public void calculateAndSetValue3(long value) {
		logger.trace("calculateAndSetValue3: value = " + value);
		value -= 133;
		if (value > Integer.MAX_VALUE) {
			value1 = (int) (value / Integer.MAX_VALUE);
			logger.debug("calculateAndSetValue3: value > Integer.MAX_VALUE, value1 = " + value1);
		}
		else {
			value1 = (int) value;
			logger.debug("calculateAndSetValue3: values <= Integer.MAX_VALUE, value1 = " + value1);
		}
	}
	
	public void printString() {
		logger.trace("printString");
		if (value2 != null) {
			System.out.println(value2.length());
		}
	}
	
	public void printDateAsLong() {
		logger.trace("printDateAsLong");
		if (value3 != null) {
			System.out.println(value3.getTime());
		}
	}
	
	public void divide(int number1, int number2) {
		logger.trace("divide: number1 = " + number1 + ", number2= " + number2);
		try {
			System.out.println(number1 / number2);
		} catch (ArithmeticException e) {
			logger.error("ArithmeticException: number1 = " + number1 + ", number2 = " + number2, e);
		}
	}
	
	public void setValue1(int value1) {
		this.value1 = value1;
		logger.debug("setValue1: this.value1 = " + value1);
	}
	
	public void setValue2(String value2) {
		this.value2 = value2;
		logger.debug("setValue2: this.value2 = " + value2);
		
	}
	
	public void setValue3(Date value3) {
		this.value3 = value3;
		logger.debug("setValue3: this.value3 = " + value3);
		
	}
	
}
