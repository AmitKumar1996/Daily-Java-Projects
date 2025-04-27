package com.amit.CrudAmit;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudAmitApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudAmitApplication.class, args);
		System.out.println("jay Shri Ram!");
	}

}
