package lesson7;

public class ClassAndObjectAndConstructorsHome {

    public static void main(String[] args) {

        Employee e1 = new Employee();
        Employee e2 = new Employee("name");
        Employee e3 = new Employee("name1", "surname1");
        Employee e4 = new Employee("name2", "phone", 1200);

        System.out.println("\nEmployee 1:");
        System.out.println("Heç bir dəyişənin dəyəri yoxdur");

        System.out.println("\nEmployee 2:");
        System.out.println(e2.name );

        System.out.println("\nEmployee 3:");
        System.out.println(e3.name + " " + e3.surname);

        System.out.println("\nEmployee 4:");
        System.out.println( e4.name + " " + e4.phone  + e4.salary);
    }
}
