package pass_by_reference;

public class MainClass {
	public static void main(String[] args) {
		Person p1 = new Person("name", "surname", 3, "phone");
		
		SalaryCalculator sCalculator = new SalaryCalculator();
		sCalculator.calculateSalary(p1);
		p1.printInfo();
	}
}
