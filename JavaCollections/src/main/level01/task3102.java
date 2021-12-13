package level01;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class task3102 {
	
	public static List<String> getFileTree(String root)
			throws IOException {
		PriorityQueue<File> folderQueue = new PriorityQueue<>();
		ArrayList<String> filePaths = new ArrayList<>();
		File rootFolder = new File(root);
		File file;
		folderQueue.addAll(Arrays.asList(Objects.requireNonNull(rootFolder.listFiles())));
		
		while (!folderQueue.isEmpty()) {
			file = folderQueue.poll();
			if (file.isFile()) {
				filePaths.add(file.getAbsolutePath());
			}
			else {
				folderQueue.addAll(Arrays.asList(file.listFiles()));
			}
		}
		return filePaths;
		
	}
	
	public static void main(String[] args) {
		List<String> filePaths = new ArrayList<>();
		try {
			filePaths = task3102.getFileTree("C:\\Users\\vadim.alekseyev\\Documents\\Icons");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(filePaths);
	}
	
}
