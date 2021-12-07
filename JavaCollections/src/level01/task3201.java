package level01;

import java.io.IOException;
import java.io.RandomAccessFile;

public class task3201 {
	
	public static void main(String[] args) {
		String path = args[0];
		long position = Long.parseLong(args[1]);
		String text = args[2];
		
		try (RandomAccessFile raf = new RandomAccessFile(path, "rw")) {
			if (raf.length() < (text.length() + position)) {
				raf.seek(raf.length());
				raf.write(text.getBytes());
			}
			else {
				raf.seek(position);
				raf.write(text.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
