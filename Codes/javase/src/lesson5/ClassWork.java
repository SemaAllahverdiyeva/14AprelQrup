package lesson5;

import java.util.Scanner;

public class ClassWork {
	public static void main(String[] args) {
		// Task1
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Yasinizi daxil edin: ");
//		int age = sc.nextInt();
//		
//		if(age < 18) {
//			System.out.println("Acces denied!");
//		}else {
//			System.out.println("Acces granted!");
//		}
//		
//		sc.close();

		// Task2
		Scanner sc = new Scanner(System.in);
		System.out.println("Gun daxil edin: ");
		int day = sc.nextInt();
		switch (day) {
		case 1: {
			System.out.println("Bazar ertesi");
		}
		case 2: {
			System.out.println("Cersenbe axsami");
		}
		case 3: {
			System.out.println("Cersenbe");
		}
		case 4: {
			System.out.println("Cume axsami");
		}
		case 5: {
			System.out.println("Cume");
		}
		case 6: {
			System.out.println("Senbe");
		}
		case 7: {
			System.out.println("Bazar");
		}
		default:
			System.out.println("Bele gun yoxdur");
		}
		sc.close();
	}
}
