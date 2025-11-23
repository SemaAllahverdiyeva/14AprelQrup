package lesson9;

public class Methods {
	// Task1
	public int squareOfNumber(int num) {
		return num * num;
	}

	// Task2
	public static int maxNum(int a, int b) {
		int maxNum = Math.max(a, b);
		return maxNum;
	}

	// Task3
	public boolean oddOrEvenNumber(int num) {
		if (num % 2 != 0) {
			return true;
		} else {
			return false;
		}
	}
}
