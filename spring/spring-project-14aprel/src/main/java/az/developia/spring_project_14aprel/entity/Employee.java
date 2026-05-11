package az.developia.spring_project_14aprel.entity;

public class Employee {

    private Integer id;
    private String name;
    private Integer age;
    private Double salary;
    private Computer computer;

    public Employee() {
        this.id = 1;
        this.name = "name";
        this.age = 25;
        this.salary = 1500.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}