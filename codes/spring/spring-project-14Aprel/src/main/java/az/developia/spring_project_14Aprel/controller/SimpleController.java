package az.developia.spring_project_14Aprel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/simple")
    public String home() {
        return "g";
    }
}