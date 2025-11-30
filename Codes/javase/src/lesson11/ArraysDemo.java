package lesson11;

public class ArraysDemo {
	public static void main(String[] args) {
		int[] arr = { 12, 5, 7, 3, 20 };

		for (int i : arr) {
			System.out.println(i);
		}

		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		System.out.print("Tek elementler: ");
		for (int num : arr) {
			if (num % 2 != 0) {
				System.out.print(num + " ");
			}
		}

		System.out.println("\nEn kicik element: " + min);
	}

}
