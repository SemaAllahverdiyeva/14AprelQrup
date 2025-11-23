package lesson9;

public class HomeWork {
	public static void main(String[] args) {
		Methods calculation = new Methods();
		
		int squareOfNumber = calculation.squareOfNumber(7);
		System.out.println(squareOfNumber);
		
		int maxNumber = Methods.maxNum(7, 21);
		System.out.println(maxNumber);
		
		boolean oddOrEvenNumber = calculation.oddOrEvenNumber(7);
		System.out.println(oddOrEvenNumber);
	}
}
