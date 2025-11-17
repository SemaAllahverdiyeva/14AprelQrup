package lesson7;

public class ClassAndObjectHome {

    public static void main(String[] args) {

        Person p1 = new Person(0, "name", "surname", 0, "phone");
        Person p2 = new Person(0, "name", "surname", 0, "phone");

        System.out.println("Person 1:");
        System.out.println("ID: " + p1.id);
        System.out.println("Name: " + p1.name);
        System.out.println("Surname: " + p1.surname);
        System.out.println("Age: " + p1.age);
        System.out.println("Phone: " + p1.phone);

        System.out.println("\nPerson 2:");
        System.out.println("ID: " + p2.id);
        System.out.println("Name: " + p2.name);
        System.out.println("Surname: " + p2.surname);
        System.out.println("Age: " + p2.age);
        System.out.println("Phone: " + p2.phone);
    }
}