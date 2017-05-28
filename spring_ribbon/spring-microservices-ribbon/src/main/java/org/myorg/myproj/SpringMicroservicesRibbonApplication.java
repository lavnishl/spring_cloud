package org.myorg.myproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name="basic-service",configuration=BasicServiceConfiguration.class)
public class SpringMicroservicesRibbonApplication {

	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	public RestTemplate restTemplate;
	
	@RequestMapping("/callServer")
	public String callServer() {
		return restTemplate.getForObject("http://basic-service/run", String.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesRibbonApplication.class, args);
	}
}
