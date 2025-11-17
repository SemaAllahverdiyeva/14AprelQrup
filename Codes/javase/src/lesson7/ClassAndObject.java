package lesson7;

	public class ClassAndObject {

	    public static void main(String[] args) {

	        Book b1 = new Book(0, "name", "author", 0, "description");

	        Book b2 = new Book(0, "name", "author", 0, "description");

	        System.out.println("Book 1:");
	        System.out.println("ID: " + b1.id);
	        System.out.println("Name: " + b1.name);
	        System.out.println("Author: " + b1.author);
	        System.out.println("Page Count: " + b1.pageCount);
	        System.out.println("Description: " + b1.description);

	        System.out.println("\nBook 2:");
	        System.out.println("ID: " + b2.id);
	        System.out.println("Name: " + b2.name);
	        System.out.println("Author: " + b2.author);
	        System.out.println("Page Count: " + b2.pageCount);
	        System.out.println("Description: " + b2.description);
	    }
	}
