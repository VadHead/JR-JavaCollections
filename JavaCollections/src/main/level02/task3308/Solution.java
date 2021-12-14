package level02.task3308;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;

public class Solution {
	public static void main(String[] args)
			throws JAXBException, FileNotFoundException {
		FileReader fReader = new FileReader("JavaCollections/src/main/level02/task3308/data.xml");
		
		JAXBContext context = JAXBContext.newInstance(getClassName());
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		Object o = unmarshaller.unmarshal(fReader);
		
		System.out.println(o.toString());
	}
	
	public static Class getClassName() {
		return Shop.class;
	}}
