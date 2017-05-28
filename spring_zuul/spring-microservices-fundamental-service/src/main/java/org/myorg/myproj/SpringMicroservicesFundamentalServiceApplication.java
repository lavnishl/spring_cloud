package org.myorg.myproj;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringMicroservicesFundamentalServiceApplication {

	@Value("${server.port}")
	public String port;
	
	@RequestMapping("/run")
	public String run() {
		Date d = new Date();
		return "Basic Service run at "+d.toGMTString()+" at port "+ port;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesFundamentalServiceApplication.class, args);
	}
}
