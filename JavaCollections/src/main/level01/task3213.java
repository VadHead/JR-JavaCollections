package level01;

import java.io.IOException;
import java.io.StringReader;

public class task3213 {
	public static void main(String[] args) throws IOException {
		StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
		System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
	}
	
	public static String decode(StringReader reader, int key)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		int ch;
		if (reader != null) {
			while ((ch = reader.read()) != -1) {
				sb.append((char) (ch + key));
			}
		}
		return sb.toString();
	}
}
