package lesson7;

class Computer {

    Integer id;
    String brand;
    String model;
    String color;

    Computer() {
        System.out.println("Default constructor işlədi.");
    }

    Computer(String model) {
        this.model = model;
        System.out.println("Constructor (model): " + model);
    }

    Computer(String model, String color) {
        this.model = model;
        this.color = color;
        System.out.println("Constructor (model, color): " + model + ", " + color);
    }
}
