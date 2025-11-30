package lesson11;

import java.util.Arrays;
import java.util.Iterator;

public class ArraysDemoHome {
	public static void main(String[] args) {
		int[] numbers = { 2, 4, 5, 7 };

		// 1
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		System.out.println("sum: " + sum + "\n");

//		for (int i : numbers) {
//			System.out.println(i);
//		}

		System.out.println("numbers: " + Arrays.toString(numbers));

		// 2
		int average = sum / 4;
		System.out.println("\nAverage: " + average);

		// 3
		int min = numbers[0];
		int max = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] < min) {
				min = numbers[i];
			}

			if (numbers[i] > max) {
				max = numbers[i];
			}
		}

		System.out.println("\nmin: " + min + "\n" + "max: " + max + "\n");

		// 4
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				System.out.println(numbers[i] + ": even number");
			} else {
				System.out.println(numbers[i] + ": odd number");
			}
		}

		// 5
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1) {
				System.out.println("not prime");
			} else if (numbers[i] == 2) {
				System.out.println("prime");
			} else if (numbers[i] % 2 == 0) {
				System.out.println("not prime");
			} else {
				System.out.println("prime");
			}

			for (int j = 3; j < numbers.length; j++) {
				if (numbers[i] % j == 0) {
					System.out.println("not prime");
				}
			}
		}
		// 6
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
	}
}
