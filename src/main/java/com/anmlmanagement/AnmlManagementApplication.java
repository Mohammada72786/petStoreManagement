package com.anmlmanagement;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anmlmanagement.dao.DogDao;
import com.anmlmanagement.model.Dog;
import com.anmlmanagement.util.constant.Gender;

@SpringBootApplication
public class AnmlManagementApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AnmlManagementApplication.class, args);
	}

}
