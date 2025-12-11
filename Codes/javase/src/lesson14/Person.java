package lesson14;

public class Person {
	char gender;
	public static String name;
	private int age;
	protected boolean isStudent;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(int age, String name, boolean isStudent, char gender) {
		this.age = age;
		Person.name = name;
		this.isStudent = isStudent;
		this.gender = gender;
	}
	
	public final void printInfo() {
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		System.out.println("gender: " + gender);
		System.out.println("isStudent: " + isStudent);
	}
}
