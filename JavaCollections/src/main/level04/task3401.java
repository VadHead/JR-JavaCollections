package level04;

public class task3401 {
	
	public static void main(String[] args) {
		task3401 solution = new task3401();
		
		System.out.println(solution.fibonacci(9));     //34
		System.out.println(solution.fibonacci(5));     //5
		System.out.println(solution.fibonacci(2));     //1
		System.out.println(solution.fibonacci(1));     //1
	}
	
	public int fibonacci(int n) {
		if (n > 2) {
			return fibonacci(n - 1) + fibonacci(n - 2);
		} return 1;
	}
	
}
