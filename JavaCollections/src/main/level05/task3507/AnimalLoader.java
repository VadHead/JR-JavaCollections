package level05.task3507;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AnimalLoader extends ClassLoader {
	
	@Override
	protected Class<?> findClass(String name)
			throws ClassNotFoundException {
		try {
			Path files = Paths.get(name);
			byte[] bytes = Files.readAllBytes(files);
			return defineClass(null, bytes, 0, bytes.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.findClass(name);
	}
	
}
