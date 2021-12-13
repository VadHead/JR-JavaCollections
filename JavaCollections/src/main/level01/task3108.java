package level01;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class task3108 {
	public static void main(String[] args) throws IOException {
		Path path1 = Paths.get("C:\\Users\\vadim.alekseyev\\IdeaProjects\\JR-JavaCollections\\JavaCollections\\test_dir_1");
		Path path2 = Paths.get("C:\\Users\\vadim.alekseyev\\IdeaProjects\\JR-JavaCollections\\JavaCollections\\test_files_tree\\dir_2_1");
		Path resultPath = getDiffBetweenTwoPaths(path1, path2);
		System.out.println(resultPath);   //expected output '../secondDir/third' or '..\secondDir\third'
	}
	
	public static Path getDiffBetweenTwoPaths(Path path1, Path path2) {
		return path1.relativize(path2);
	}
}
