package az.developia.courseManagementSystem.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import az.developia.courseManagementSystem.entity.Teachers;

public class TeachersRepository {
	String query = "INSERT INTO students (first_name, last_name, age, grade, city, scholarship, registration_date)\r\n"
			+ "VALUES (\"Nigar\" , \"Memmedova\", 35, 95, \"Bakı\", 7, '02-09-1996'),\r\n"
			+ "	   (\"Minaye\" , \"Abbaszade\", 23, 97, \"Gəncə\", 0, '13-21-1995'),";
	public void add(Teachers t) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost3306/course_system_db", "root", "sema2013");
			Statement st = conn.createStatement();
			st.executeUpdate(null);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
