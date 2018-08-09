package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private final static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		logger.info("-------------------项目启动-------------");
		SpringApplication.run(DemoApplication.class, args);
	}
}
