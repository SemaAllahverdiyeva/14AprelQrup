package lesson8;

import java.util.Scanner;

public class MethodsHome {
	public static void printNumbers(int begin, int end) {
		for (int i = begin; i < end; i++) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int begin = sc.nextInt();
		int end = sc.nextInt();
		printNumbers(begin , end);
	}
}
