package pass_by_reference;

public class SalaryCalculator {
	public void calculateSalary(Person p) {
		switch (p.exprenceYear) {
		case 1: {
			p.salary = 500;
			break;
		}
		case 2: {
			p.salary = 1000;
			break;
		}
		case 3: {
			p.salary = 1500;
			break;
		}
		}
	}
}