package az.developia.studentManagementSystem.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import az.developia.studentManagementSystem.entity.Book;
import az.developia.studentManagementSystem.entity.Student;
import az.developia.studentManagementSystem.exception.NameTooLongException;

public class StudentRepository {
	public void addStudent(Student student) throws NameTooLongException {

		if (student.getName().length() > 45) {
			throw new NameTooLongException("You can enter a maximum of 45 characters.");
		}

		String query = "INSERT INTO students (name, surname, age, username, password) VALUES ('" + student.getName()
				+ "', '" + student.getSurname() + "', '" + student.getAge() + "', '" + student.getUsername() + "', '"
				+ student.getPassword() + "')";

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false", "root",
					"1608");
			Statement st = conn.createStatement();
			st.executeUpdate(query);
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean checkUser(String username) {

		boolean userIsExists = false;

		String query = "SELECT COUNT(*) FROM students WHERE username = '" + username + "';";

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false", "root",
					"1608");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			userIsExists = rs.getInt(1) == 1 ? true : false;
			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return userIsExists;
	}

	public boolean login(String username, String password) {

		boolean userIsExists = false;

		String query = "SELECT COUNT(*) FROM students WHERE username = '" + username + "' AND password = '" + password
				+ "'";

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false", "root",
					"1608");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			userIsExists = rs.getInt(1) == 1 ? true : false;
			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return userIsExists;
	}

	public void addBook(Book book) {
		String query = "INSERT INTO students (title, author, publicationYear, registerDate) VALUES ('" +  "', '" + book.getTitle() + "', '" + book.getAuthor() + "', '" + book.getPublicationYear() + "', '"
				+ book.getRegisterDate() + "')";
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?useSSL=false", "root",
					"1608");
			Statement st = conn.createStatement();
			st.executeUpdate(query);
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
