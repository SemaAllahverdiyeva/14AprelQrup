package lesson14;

public class ModifiersDemo {
	public static void main(String[] args) {
		Person p1 = new Person(12, "name", true, 'M');
		p1.printInfo();
		p1.setAge(13);
		System.out.println(p1.getAge());
	}
}
