package com.bashboard.Bashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bashboard")
public class BashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BashboardApplication.class, args);
	}

}
