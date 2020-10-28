package org.hmily.logfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LogfileDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogfileDemoApplication.class, args);
	}

}
