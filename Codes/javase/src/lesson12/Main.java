package lesson12;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = { 1, 0, 4, 3, 5, 2, 9, 6, 10, 7 };

		// 1
		System.out.println(Arrays.toString(arr));

		// 2
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		// 3
		int[] copyArray = Arrays.copyOf(arr, 5);
		System.out.println(Arrays.toString(copyArray));

		// 4
		Arrays.fill(copyArray, 7);
		System.out.println(Arrays.toString(copyArray));

		// 5
		System.out.println(Arrays.equals(arr, copyArray));

		// 6
		int searchedValue = sc.nextInt();

		for (int i : copyArray) {
			if (i == searchedValue) {
				System.out.println("true");
				break;
			}else {
				System.out.println("false");
				break;
			}
		}
	}
}
