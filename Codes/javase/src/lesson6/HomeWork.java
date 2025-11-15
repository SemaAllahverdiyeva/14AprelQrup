package lesson6;

import java.util.Scanner;

public class HomeWork {
	public static void main(String[] args) {
		// 3
		Scanner sc = new Scanner(System.in);

		System.out.println("Ədəd 1: ");
		int a = sc.nextInt();
		System.out.println("Ədəd 2: ");
		int b = sc.nextInt();
		System.out.println("Cəm: " + a * b);
		System.out.println();

		// 4
		System.out.print("Radius: ");
		int r = sc.nextInt();
		System.out.println("pi(təxminən): " + 3);
		System.out.println("C= " + 2 * 3 * r);
		System.out.println();

		// 5
		int number = sc.nextInt();
		int sum = 0;

		while (number != 0) {
			sum += number % 10;
			number /= 10;
		}
		System.out.println(sum);

		// 7
		int sum2 = 0;
		for (int i = 0; i <= 100; i++) {
			sum2 += i;
		}
		System.out.println(sum2);

		// 8
		int sum3 = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 7 == 0) {
				sum3 += i;
			}
		}
		System.out.println(sum3);
		
		//9
		int d = sc.nextInt();
		
		if(d % 2 ==0) {
			System.out.println("Cüt ededdir");
		}else {
			System.out.println("Cüt eded deyil");
		}
		
		//10
		int sum4 = 0;
		for (int i = 0; i <= 200; i++) {
			if (i % 3 == 0 && i % 7 == 0) {
				sum4 += i;
			}
		}
		System.out.println(sum4);
		
		sc.close();
	}
}
