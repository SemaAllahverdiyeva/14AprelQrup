package az.developia.spring_project_14Aprel.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import az.developia.spring_project_14Aprel.entity.Computer;

@Repository
public class ComputerRepository {

	@Autowired
	private DataSource dataSource;

	public List<Computer> getComputers(String brand) {
		List<Computer> computers = new ArrayList<>();

		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();

			String query = "select * from computers";

			if (brand != null && !brand.isEmpty()) {
				query = "select * from computers where brand='" + brand + "'";
			}

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				Computer c = new Computer();
				c.setId(rs.getInt("id"));
				c.setBrand(rs.getString("brand"));
				c.setModel(rs.getString("model"));
				computers.add(c);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return computers;
	}

	public Optional<Computer> getComputerById(int id) {
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(
				"select * from computers where id=" + id);

			if (rs.next()) {
				Computer c = new Computer();
				c.setId(rs.getInt("id"));
				c.setBrand(rs.getString("brand"));
				c.setModel(rs.getString("model"));
				conn.close();
				return Optional.of(c);
			}

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

	public void addComputer(Computer computer) {
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();

			String query =
				"insert into computers(brand,model) values('"
				+ computer.getBrand() + "','"
				+ computer.getModel() + "')";

			st.executeUpdate(query);
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteComputer(int id) {
		try {
			Connection conn = dataSource.getConnection();
			Statement st = conn.createStatement();

			String query = "delete from computers where id=" + id;
			st.executeUpdate(query);

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Computer computer) {
		
	}
}