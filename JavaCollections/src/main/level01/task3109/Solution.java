package level01.task3109;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Solution {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		Properties properties = solution.getProperties(
				"JavaCollections\\src\\level01\\task3109\\properties.xml");
		properties.list(System.out);
		
		properties = solution.getProperties("JavaCollections\\src\\level01\\task3109\\properties.txt");
		properties.list(System.out);
		
		properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
		properties.list(System.out);
	}
	
	public Properties getProperties(String fileName) {
		Properties properties = new Properties();
		try (FileInputStream fileInStream = new FileInputStream(fileName)) {
			if (fileName.substring(fileName.lastIndexOf(".") + 1).equals("xml")) {
				properties.loadFromXML(fileInStream);
			}
			else {
				properties.load(fileInStream);
			}
		} catch (IOException e) {
			return properties;
		}
		
		return properties;
	}
	
}
