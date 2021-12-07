package level01;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;

public class task3203 {
	public static void main(String[] args) {
		String text = getStackTrace(new IndexOutOfBoundsException("fff"));
		System.out.println(text);
	}
	
	public static String getStackTrace(Throwable throwable) {
		Writer sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		throwable.printStackTrace(pw);
		return sw.toString();
	}
}
