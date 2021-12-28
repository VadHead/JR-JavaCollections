package level05;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class task3504 <T extends HashMap>{
	private HashMap map;
	
	public task3504(HashMap map) {
		this.map = map;
	}
	
	public HashMap getMap() {
		return map;
	}
	
	public static void main(String[] args) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.put("string", 4);
		task3504 solution = new task3504(hashMap);
		HashMap mapFromSolution = solution.getMap();
		System.out.println(mapFromSolution.getClass());
		
		
		LinkedHashMap<task3504, task3504> hashMap2 = new LinkedHashMap<>();
		hashMap2.put(solution, solution);
		task3504 solution2 = new task3504(hashMap2);
		LinkedHashMap mapFromSolution2 = (LinkedHashMap) solution2.getMap();   //need to cast  :(
		System.out.println(mapFromSolution2.getClass());
	}
}
