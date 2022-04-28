package com.texas.studentstatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class StudentStatusSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentStatusSystemApplication.class, args);
	}

}
