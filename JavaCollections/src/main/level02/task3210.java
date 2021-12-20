package level02;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class task3210 {
	
	public static void main(String[] args) {
		String path = args[0];
		long position = Long.parseLong(args[1]);
		String text = args[2];
		
		try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
			byte[] fileContent = new byte[text.length()];
			raf.seek(position);
			raf.read(fileContent, 0, text.length());
			raf.seek(raf.length());
			
			String readString = new String(fileContent);
			
			if (readString.equals(text)) {
				raf.write("true".getBytes());
			}
			else {
				raf.write("false".getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
