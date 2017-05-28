package org.myorg.myproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@SpringBootApplication
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class SpringMicroservicesHystrixApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/startClients")
	@HystrixCommand(fallbackMethod="failover", commandProperties = {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="500")
	})
	public String startTheClients(@RequestParam long time) throws InterruptedException {
		Thread.sleep(time);
		return restTemplate.getForObject("http://localhost:8883/execute", String.class);
	}
	
	// FailOver MUST have same signature as original method
	public String failover(long time) {
		return "failover";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesHystrixApplication.class, args);
	}
}
