package lesson8;

public class Methods {
		public static void printName(int count, String name) {
			for(int i = 0; i < count ; i++) {
				System.out.println(name);
			}
		}
		
		public static void main(String[] args) {
			Methods.printName(5 , "a");
			Methods.printName(7 , "b");
			Methods.printName(3 , "c");			
		}
}



