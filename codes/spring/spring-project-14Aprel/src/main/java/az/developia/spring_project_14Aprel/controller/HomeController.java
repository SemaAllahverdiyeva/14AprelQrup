package az.developia.spring_project_14Aprel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(path = "/")
	public String getHome() {
		return "home";
	}

	private Logger log = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/hello")
	public String hello() {
		log.info("Hello endpoint");
		return "";
	}

}
