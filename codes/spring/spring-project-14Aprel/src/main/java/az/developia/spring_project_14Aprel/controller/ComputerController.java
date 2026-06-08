package az.developia.spring_project_14Aprel.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.developia.spring_project_14Aprel.entity.Computer;

@RestController
@RequestMapping(path = "/computers")
public class ComputerController {

	@Autowired
	private DataSource dataSource;

	@GetMapping("/getComputers")
	public List<Computer> getComputers(
			@RequestParam(required = false) String brand) {

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

				Computer computer = new Computer();

				computer.setId(rs.getInt("id"));
				computer.setBrand(rs.getString("brand"));
				computer.setModel(rs.getString("model"));

				computers.add(computer);
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return computers;
	}

	@GetMapping("/getComputer/{id}")
	public Computer getComputer(int id) {

		try {

			Connection conn = dataSource.getConnection();

			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(
					"select * from computers where id=" + id);

			if (rs.next()) {

				Computer computer = new Computer();

				computer.setId(rs.getInt("id"));
				computer.setBrand(rs.getString("brand"));
				computer.setModel(rs.getString("model"));

				conn.close();

				return computer;
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@PostMapping("/addComputer")
	public String addComputer(@RequestBody Computer computer) {

		try {

			Connection conn = dataSource.getConnection();

			Statement st = conn.createStatement();

			String query =
					"insert into computers(brand,model) values('"
					+ computer.getBrand()
					+ "','"
					+ computer.getModel()
					+ "')";

			st.executeUpdate(query);

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Computer added successfully";
	}
}