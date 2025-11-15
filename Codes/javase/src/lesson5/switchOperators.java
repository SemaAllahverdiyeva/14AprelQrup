package lesson5;

import java.util.Scanner;

public class switchOperators {
	public static void main(String[] args) {
		// Task1
		Scanner sc = new Scanner(System.in);
		System.out.print("Gün nömrəsini daxil edin: ");
		int gun = sc.nextInt();
		switch (gun) {
		case 1:
			System.out.println("Bazar ertəsi");
			break;
		case 2:
			System.out.println("Çərşənbə axşamı");
			break;
		case 3:
			System.out.println("Çərşənbə");
			break;
		case 4:
			System.out.println("Cümə axşamı");
			break;
		case 5:
			System.out.println("Cümə");
			break;
		case 6:
			System.out.println("Şənbə");
			break;
		case 7:
			System.out.println("Bazar");
			break;
		default:
			System.out.println("Yanlış gün");
		}
		// Task2
		System.out.print("Ay nömrəsini daxil edin: ");
		int ay = sc.nextInt();

		switch (ay) {
		case 12:
		case 1:
		case 2:
			System.out.println("Qış");
			break;

		case 3:
		case 4:
		case 5:
			System.out.println("Yaz");
			break;

		case 6:
		case 7:
		case 8:
			System.out.println("Yay");
			break;

		case 9:
		case 10:
		case 11:
			System.out.println("Payız");
			break;

		default:
			System.out.println("Yanlış ay");
		}

		// Task3

		System.out.print("Ay nömrəsini daxil edin: ");
		int ay1 = sc.nextInt();

		switch (ay1) {
		case 1:
			System.out.println("Yanvar");
			break;
		case 2:
			System.out.println("Fevral");
			break;
		case 3:
			System.out.println("Mart");
			break;
		case 4:
			System.out.println("Aprel");
			break;
		case 5:
			System.out.println("May");
			break;
		case 6:
			System.out.println("İyun");
			break;
		case 7:
			System.out.println("İyul");
			break;
		case 8:
			System.out.println("Avqust");
			break;
		case 9:
			System.out.println("Sentyabr");
			break;
		case 10:
			System.out.println("Oktyabr");
			break;
		case 11:
			System.out.println("Noyabr");
			break;
		case 12:
			System.out.println("Dekabr");
			break;
		default:
			System.out.println("Yanlış ay");
		}

		// Task4

		System.out.println("Məhsul seçin:");
		System.out.println("1. Alma - 1.5 AZN");
		System.out.println("2. Portağal - 2.0 AZN");
		System.out.println("3. Banan - 1.8 AZN");
		System.out.println("4. Üzüm - 3.0 AZN");
		System.out.print("Seçiminizi daxil edin: ");
		int secim = sc.nextInt();

		switch (secim) {
		case 1:
			System.out.println("Alma qiyməti: 1.5 AZN");
			break;
		case 2:
			System.out.println("Portağal qiyməti: 2.0 AZN");
			break;
		case 3:
			System.out.println("Banan qiyməti: 1.8 AZN");
			break;
		case 4:
			System.out.println("Üzüm qiyməti: 3.0 AZN");
			break;
		default:
			System.out.println("Yanlış məhsul seçimi");
		}
	}
}
