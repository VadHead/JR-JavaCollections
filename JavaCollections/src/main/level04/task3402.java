package level04;

public class task3402 {
	
	public static void main(String[] args) {
		task3402 solution = new task3402();
		
		System.out.println(solution.factorial(9));     //362880
		System.out.println(solution.factorial(0));     //1
		System.out.println(solution.factorial(1));     //1
	}
	
	public int factorial(int n) {
		if (n > 0) {
			return n * factorial(n - 1);
		}
		return 1;
		
	}
	
}
