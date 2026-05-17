package az.developia.spring_project_14Aprel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

	@GetMapping(path = "/students")
	public String getStudent() {
	    return "students";
	}
}
