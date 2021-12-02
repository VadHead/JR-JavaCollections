package level01;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class task3112 {
	public static void main(String[] args) throws IOException {
		Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C:\\Users\\vadim.alekseyev\\IdeaProjects\\JR-JavaCollections\\JavaCollections\\test_dir_1"));
		
		for (String line : Files.readAllLines(passwords)) {
			System.out.println(line);
		}
	}
	
	public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
		URL url = new URL(urlString);
		URLConnection connection = url.openConnection();
		InputStream inputStream = connection.getInputStream();
		
		String fileName = urlString.substring(urlString.lastIndexOf("/") + 1);
		Path tempFile = Files.createTempFile("temp-", "temp");
		Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
		Path resultFile = downloadDirectory.resolve(Paths.get(fileName));
		if (!Files.exists(resultFile)) {
			Files.createFile(resultFile);
		}
		Files.move(tempFile, resultFile, StandardCopyOption.REPLACE_EXISTING);
		return resultFile;
	}
}
