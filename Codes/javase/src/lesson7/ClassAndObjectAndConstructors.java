package lesson7;

public class ClassAndObjectAndConstructors {

    public static void main(String[] args) {

        Computer c1 = new Computer();
        Computer c2 = new Computer("MacBook Pro");
        Computer c3 = new Computer("Dell Inspiron", "Black");

        System.out.println("\nComputer 1:");
        System.out.println(c1.id + " " + c1.brand + " " + c1.model + " " + c1.color);

        System.out.println("\nComputer 2:");
        System.out.println(c2.id + " " + c2.brand + " " + c2.model + " " + c2.color);

        System.out.println("\nComputer 3:");
        System.out.println(c3.id + " " + c3.brand + " " + c3.model + " " + c3.color);
    }
}

