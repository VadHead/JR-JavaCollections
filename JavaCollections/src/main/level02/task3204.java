package level02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

public class task3204 {
	public static void main(String[] args) {
		ByteArrayOutputStream password = getPassword();
		System.out.println(password.toString());
	}
	
	public static ByteArrayOutputStream getPassword() {
		String charLower = "abcdefghijklmnopqrstuvwxyz";
		String charUpper = charLower.toUpperCase();
		String digits = "0123456789";
		StringBuilder password = new StringBuilder();
		
		Random rand = new Random();
		int randInt1;
		int randInt2;
		int randInt3;
		
		for (int i = 0; i < 2; i++) {
			randInt1 = rand.nextInt(charLower.length());
			for (int j = 0; j < 1; j++) {
				randInt2 = rand.nextInt(charUpper.length());
				password.append(charUpper.charAt(randInt2));
			}
			for (int j = 0; j < 2; j++) {
				randInt3 = rand.nextInt(digits.length());
				password.append(digits.charAt(randInt3));
			}
			password.append(charLower.charAt(randInt1));
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			baos.write(password.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos;
	}
}
