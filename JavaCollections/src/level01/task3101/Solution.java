package level01.task3101;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Solution {
	
	public static void main(String[] args)
			throws IOException {
//		String dirPath = args[0];
//		String resultFileAbsolutePath = args[1];
		String dirPath = "JavaCollections/text";
		String resultFileAbsolutePath = "C:\\Users\\vadim.alekseyev\\IdeaProjects\\JR-JavaCollections\\JavaCollections\\test.txt";
		
		File dir = new File(dirPath);
		File resultFile = new File(resultFileAbsolutePath);
		File destinationFile = new File(resultFile.getParent() + "/allFilesContent.txt");
		if (FileUtils.isExist(destinationFile)) {
			FileUtils.deleteFile(destinationFile);
		}
		FileUtils.renameFile(resultFile, destinationFile);
		
		PriorityQueue<File> folderQueue = new PriorityQueue<>();
		Map<String, File> filesMap = new TreeMap<>();
		File file;
		folderQueue.addAll(Arrays.asList(dir.listFiles()));
		
		while (!folderQueue.isEmpty()) {
			file = folderQueue.poll();
			if (file.isFile() && file.length() <= 50) {
				filesMap.put(file.getName(), file);
			}
			else if (file.isDirectory()) {
				folderQueue.addAll(Arrays.asList(file.listFiles()));
			}
		}
		
		FileOutputStream fos = new FileOutputStream(destinationFile);
		for (Map.Entry<String, File> entry: filesMap.entrySet()  ) {
			fos.write(Files.readAllBytes(entry.getValue().toPath()));
			fos.write("\n".getBytes());
		}
		fos.close();
		
	}
}
