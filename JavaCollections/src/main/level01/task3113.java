package level01;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class task3113 {
	
	public static void main(String[] args)
			throws IOException {
		Scanner scanner = new Scanner(System.in);
		String dirPath = scanner.nextLine();
		Path dir = Paths.get(dirPath);
		if (!Files.isDirectory(dir)) {
			System.out.println(dir.toAbsolutePath() + " - не папка");
		}
		else {
			AtomicInteger foldersCount = new AtomicInteger();
			AtomicInteger filesCount = new AtomicInteger();
			AtomicLong byteSize = new AtomicLong();
			
			SimpleFileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
				public FileVisitResult preVisitDirectory(Path d, BasicFileAttributes attrs)
						throws IOException {
					if (!d.equals(dir)) {
						foldersCount.incrementAndGet();
					}
					return FileVisitResult.CONTINUE;
				}
				
				public FileVisitResult visitFile(Path d, BasicFileAttributes attrs) {
					filesCount.incrementAndGet();
					byteSize.addAndGet(attrs.size());
					return FileVisitResult.CONTINUE;
				}
			};
			
			Files.walkFileTree(dir, visitor);
			System.out.println("Всего папок - " + foldersCount);
			System.out.println("Всего файлов - " + filesCount);
			System.out.println("Общий размер - " + byteSize);
		}
		
	}
	
}
