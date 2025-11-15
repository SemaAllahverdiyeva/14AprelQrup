package lesson5;

import java.util.Scanner;

public class if_elseOperators {
public static void main(String[] args) {
	//Task1

	Scanner sc = new Scanner(System.in);
	System.out.println("Yaşınızı daxil edin: ");
	int age = sc.nextInt();
	if (age >= 18) {
	System.out.println("Yetişkinsən");
	}else{
	System.out.println("Uşaqsan");
	}

	//Task2

	System.out.println( "1-ci ədədi daxil edin");
	int num1 = sc.nextInt();

	System.out.println( "2-ci ədədi daxil edin");
	int num2 = sc.nextInt();

	if ( num1 > num2  ) {
	System.out.println("1-ci ədəd böyükdür");
	} else if ( num1 == num2 ) {
	System.out.println("İki ədəd bərabərdir");
	}else {
	System.out.println("2-ci ədəd böyükdür");
	}

	//Task3

	System.out.print("Riyaziyyat balınız: ");
	int riyaziyyat = sc.nextInt();

	System.out.print("Fizika balınız: ");
	int fizika = sc.nextInt();

	if (riyaziyyat >= 60) {
	System.out.println("Hər iki dərsdən keçdiniz");
	} else if (riyaziyyat < 60 && fizika < 70) {
	System.out.println("Hər iki dərsdən kəsildiniz");
	} else {
	System.out.println("Bir fəndən uğurla keçdiniz, digər fəndən kəsildiniz");
	}

	//Task4

	System.out.println("Həftənin hər hansı bir gününü daxil edin: ");
	String gün = sc.nextLine();

	if ( gün == "Şənbə" || gün == "Bazar") {
	System.out.println("Həftə sonu");
	} else if ( gün == "Bazar ertəsi" || gün == "Cümə") {
	System.out.println("Həftənin başlanğıcı və ya sonu");
	} else {
	System.out.println("Həftə içi");
	}
}
}
