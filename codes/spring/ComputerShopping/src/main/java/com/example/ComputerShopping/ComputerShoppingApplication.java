package com.example.ComputerShopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import az.developia.spring_project_14Aprel.SpringProject14AprelApplication;
import az.developia.spring_project_14Aprel.config.AppProperties;

@SpringBootApplication
public class ComputerShoppingApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringProject14AprelApplication.class, args);
	}

}
