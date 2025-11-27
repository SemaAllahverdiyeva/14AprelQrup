package lesson10;

public class Main {
public static void main(String[] args) {
	Circle c = new Circle();
	c.radius = 7;
	Calculator calculator = new Calculator();
	calculator.calculateCircleLength(c);
	System.out.println(c.lengt);
}
}
