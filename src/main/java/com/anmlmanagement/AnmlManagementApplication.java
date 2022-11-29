package com.anmlmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.anmlmanagement.dao.UserDao;
import com.anmlmanagement.model.User;

@SpringBootApplication
public class AnmlManagementApplication implements CommandLineRunner {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AnmlManagementApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		User abid = new User();
		User mohd = new User();
		abid.setEmail("abid@gmail.com");
		abid.setPassword(this.bCryptPasswordEncoder.encode("Mohammad"));
		abid.setUsername("Abid");
		abid.setRole("ROLE_NORMAL");
		
		mohd.setEmail("mohd@gmail.com");
		mohd.setPassword(this.bCryptPasswordEncoder.encode("Abid"));
		mohd.setUsername("Mohammad");
		mohd.setRole("ROLE_ADMIN");
		
		//this.userDao.save(mohd);
		//this.userDao.save(abid);
	}

}
