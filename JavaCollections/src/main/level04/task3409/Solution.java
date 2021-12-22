package level04.task3409;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Solution {
	
	public static void main(String args[])
			throws IOException {
		String logProperties =
				"JavaCollections/src/main/" + Solution.class.getPackage().getName().replaceAll("[.]", "/")
						+ "/src/log4j.properties";
		Path path = Paths.get(logProperties).toAbsolutePath();
		try (InputStream is = new FileInputStream(path.toFile())) {
			Properties properties = new Properties();
			properties.load(is);
		}
	}
	
}
