package level04;

public class task3403 {
	
	public static void main(String[] args) {
		task3403 task = new task3403();
		
		task.recurse(12);
	}
	
	public void recurse(int n) {
		if (n <= 1) {
			return;
		}
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				System.out.print(i + " ");
				recurse(n / i);
				break;
			}
		}
	}
	
}
