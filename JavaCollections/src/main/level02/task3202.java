package level02;

import java.io.*;

public class task3202 {
	public static void main(String[] args) throws IOException {
		StringWriter writer = getAllDataFromInputStream(new FileInputStream("JavaCollections/test_dir_1/secretPasswords.txt"));
		System.out.println(writer.toString());
	}
	
	public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
		StringWriter writer = new StringWriter();
		String data;
		if (is != null) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			while ((data = reader.readLine()) != null) {
				writer.write(data);
			}
		}
		return writer;
	}
}
