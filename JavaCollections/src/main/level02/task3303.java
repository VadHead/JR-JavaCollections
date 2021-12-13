package level02;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;

public class task3303 {
	
	public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz)
			throws IOException {
		FileReader reader = new FileReader(fileName);
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(reader, clazz);
	}
	
	public static void main(String[] args) {
	
	}
	
}
