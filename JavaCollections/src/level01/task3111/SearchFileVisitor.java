package level01.task3111;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
	
	private String partOfName;
	private String partOfContent;
	private int minSize;
	private int maxSize;
	private List<Path> foundFiles = new ArrayList<Path>();
	
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		// check if file name contains search string
		if (partOfName != null && !file.getFileName().toString().contains(partOfName)) return FileVisitResult.CONTINUE;
		
		// read file content
		byte[] content = Files.readAllBytes(file);
		
		//check size of file
		if ((maxSize > 0 && content.length > maxSize) || (minSize > 0 && content.length < minSize)) return FileVisitResult.CONTINUE;
		
		// check contents of file
		if (partOfContent != null && !partOfContent.isEmpty()) {
			String contentString = new String(content);
			if (!contentString.contains(partOfContent)) return FileVisitResult.CONTINUE;
		}
		
		// if all checks are passed, add file to result list
		foundFiles.add(file);
		return super.visitFile(file, attrs);
	}
	
//	@Override
//	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
//			throws IOException {
//		if (partOfName != null && file.getFileName().toString().contains(partOfName)) {
//			return FileVisitResult.CONTINUE;
//		}
//		byte[] content = Files.readAllBytes(file);
//
//		if (partOfContent != null && !partOfContent.isEmpty()) {
//			String contentString = Arrays.toString(content);
//			if (!contentString.contains(partOfContent)) {
//				return FileVisitResult.CONTINUE;
//			}
//		}
//		if (maxSize > 0 && content.length > maxSize) {
//			return FileVisitResult.CONTINUE;
//		}
//		if (minSize > 0 && content.length < minSize) {
//			return FileVisitResult.CONTINUE;
//		}
//		foundFiles.add(file);
//		return super.visitFile(file, attrs);
//	}
	
	public void setPartOfName(String namePart) {
		this.partOfName = namePart;
	}
	
	public void setPartOfContent(String contentPart) {
		this.partOfContent = contentPart;
	}
	
	public void setMinSize(int n) {
		this.minSize = n;
	}
	
	public void setMaxSize(int n) {
		this.maxSize = n;
	}
	
	public List<Path> getFoundFiles() {
		return foundFiles;
	}
	
}
