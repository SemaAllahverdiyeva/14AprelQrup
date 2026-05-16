package az.developia.studentManagementSystem;

import java.time.LocalDateTime;

import az.developia.studentManagementSystem.entity.Book;
import az.developia.studentManagementSystem.entity.Student;
import az.developia.studentManagementSystem.exception.NameTooLongException;
import az.developia.studentManagementSystem.repository.StudentRepository;

public class Main {
	public static void main(String[] args) {
		Student student = new Student(null, "Francesca", "Romano", 23, "francesca", "f1234");

		StudentRepository repo = new StudentRepository();

		try {
			if (repo.login(student.getUsername(), student.getPassword())) {
				System.out.println("user logged in");
			} else {
				System.out.println("username or password is incorrect!");
			}

			if (repo.checkUser(student.getUsername())) {
				System.out.println("user is exists");
			} else {
				repo.addStudent(student);
				System.out.println("student was added");
			}

		} catch (NameTooLongException e) {
			System.out.println(e.getMessage());
		}

		LocalDateTime dateTime = LocalDateTime.now();
		Book b = new Book(0, "", "", 0, dateTime);
		
		repo.addBook(b);
	}
}
