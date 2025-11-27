package pass_by_reference;

public class Person {
	String name;
	String surname;
	int exprenceYear;
	double salary;
	String phone;
	
	public Person(String name, String surname, int exprenceYear, String phone) {
		this.name = name;
		this.surname = surname;
		this.exprenceYear = exprenceYear;
		this.salary = salary;
		this.phone = phone;
	}
	
	public void printInfo() {
		System.out.println("Name: " + name);
		System.out.println("Surname: " + surname);
		System.out.println("Eprence Year: " + exprenceYear);
		System.out.println("Salary: " + salary);
		System.out.println("Phone: " + phone);
	}
}
