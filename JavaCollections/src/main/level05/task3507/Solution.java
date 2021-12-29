package level05.task3507;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
		Set<? extends Animal> allAnimals = getAllAnimals(
				Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath()
						+ Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
		System.out.println(allAnimals);
	}
	
	public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
		Set<Animal> animalsSet = new HashSet<>();
		try {
			String decodePath = URLDecoder.decode(pathToAnimals, "UTF-8");
			File file = new File(decodePath);
			File[] classFiles = file.listFiles();
			AnimalLoader loader = new AnimalLoader();
			
			for (File f : classFiles) {
				Class<?> classFromFile = loader.findClass(f.getAbsolutePath());
					System.out.println("\nClass from file is: " + classFromFile.getName());
				if (Animal.class.isAssignableFrom(classFromFile)) {
						System.out.println("Class implements Animal!");
					Constructor[] constructors = classFromFile.getConstructors();
						System.out.println("Class constructors: ");
					Arrays.stream(constructors).forEach(c -> System.out.println(c.getName()));
					for (Constructor c : constructors) {
						if (c.getParameterCount() == 0 && Modifier.isPublic(c.getModifiers())) {
									System.out.println("Public constructor: " + c.getName());
							animalsSet.add((Animal) c.newInstance());
						}
					}
				}
				System.out.println("Class NOT implements Animal!");
			}
		} catch (UnsupportedEncodingException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return animalsSet;
	}
	
}

