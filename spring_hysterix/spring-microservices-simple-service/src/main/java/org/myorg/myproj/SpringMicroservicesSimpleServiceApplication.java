package org.myorg.myproj;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringMicroservicesSimpleServiceApplication {

	@RequestMapping("/execute")
	public String execute() {
		Date d = new Date();
		return "Executed Simple Service at :"+d.toString();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesSimpleServiceApplication.class, args);
	}
}
