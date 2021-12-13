package level01.task3111;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
Продвинутый поиск файлов
*/

public class Solution {
	
	public static void main(String[] args) throws IOException {
		SearchFileVisitor searchFileVisitor = new SearchFileVisitor();
		
		searchFileVisitor.setPartOfName("te");
		searchFileVisitor.setPartOfContent("es");
		searchFileVisitor.setMinSize(1);
		searchFileVisitor.setMaxSize(10000);
		
		Files.walkFileTree(Paths.get("JavaCollections/test_dir_1"), searchFileVisitor);
		
		List<Path> foundFiles = searchFileVisitor.getFoundFiles();
		for (Path file : foundFiles) {
			System.out.println(file);
		}
	}
	
}
