package lesson4;

public class HomeWork {
public static void main(String[] args) {
	int a = 21;
    int b = 7;

    int cem = a + b;
    int ferq = a - b;
    int qaliq = a % b;
    int hasil = a * b;
    int bolme = a / b; 

    System.out.println("Cəm: " + cem);
    System.out.println("Fərq: " + ferq);
    System.out.println("Qalıq: " + qaliq);
    System.out.println("Hasil: " + hasil);
    System.out.println("Bölmə: " + bolme);
    
    //Task2
    
    System.out.println("a == b: " + (a == b));
    System.out.println("a != b: " + (a != b));
    System.out.println("a < b: " + (a < b));
    System.out.println("a > b: " + (a > b));
    System.out.println("a <= b: " + (a <= b));
    System.out.println("a >= b: " + (a >= b));
    
    //Task3
    
    boolean x = true;
    boolean y = false;

    boolean andOperator = x && y;
    boolean orOperator = x || y;
    boolean notOperator = !x;

    System.out.println(andOperator);
    System.out.println(orOperator);
    System.out.println(notOperator);
}
}
