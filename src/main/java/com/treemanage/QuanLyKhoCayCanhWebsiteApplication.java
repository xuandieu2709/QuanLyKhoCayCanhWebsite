package com.treemanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.treemanage")
@EnableAutoConfiguration
public class QuanLyKhoCayCanhWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuanLyKhoCayCanhWebsiteApplication.class, args);
	}

}
