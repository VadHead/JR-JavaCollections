package level02;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

public class task3211 {
	public static void main(String... args) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject("test string");
		oos.flush();
		System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true
		
	}
	
	public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		byte[] hash = messageDigest.digest(byteArrayOutputStream.toByteArray());
		StringBuilder hashSum = new StringBuilder();
		for (byte h : hash) {
			hashSum.append(String.format("%02x", h));
		}
		return hashSum.toString().equals(md5);
	}
	
}
