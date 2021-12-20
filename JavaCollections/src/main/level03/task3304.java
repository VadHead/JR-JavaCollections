package level03;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class task3304 {
	
	public static void main(String[] args)
			throws IOException {
		Second s = (Second) convertOneToAnother(new First(), Second.class);
		First f = (First) convertOneToAnother(new Second(), First.class);
	}
	
	public static Object convertOneToAnother(Object one, Class resultClassObject)
			throws IOException {
		StringWriter writer = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(writer, one);
		String s = writer.toString();
		System.out.println(s);
		String k1 = "\"" + one.getClass().getSimpleName().toLowerCase() + "\"";
		String k2 = "\"" + resultClassObject.getSimpleName().toLowerCase() + "\"";
		s = s.replaceFirst(k1, k2);
		System.out.println(s);
		StringReader reader = new StringReader(s);
		ObjectMapper mapperNew = new ObjectMapper();
		return mapperNew.readValue(reader, resultClassObject);
	}
	
	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
	@JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
	public static class First {
		
		public int i;
		public String name;
		
	}
	
	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
	@JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
	public static class Second {
		
		public int i;
		public String name;
		
	}
	
}
