package az.developia.spring_project_14Aprel.controller;

import az.developia.spring_project_14Aprel.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

	List<Student> students = new ArrayList<>();

	@GetMapping("/students")
	public String getStudents(Model model) {

		model.addAttribute("student", new Student());
		model.addAttribute("students", students);

		return "students";
	}

	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute Student student) {

		students.add(student);

		return "students";
	}
}