package lesson11;

public class Factorial {
	public void calculateFactorial(int a) {
		int sum = 0;
		for (int i = 0; i < a; i++) {
			sum *= i;
		}
		System.out.println(sum);
	}
}
