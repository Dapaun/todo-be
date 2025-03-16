package com.project.todo_be;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoBeApplication {

	private static final Logger log = LoggerFactory.getLogger(TodoBeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TodoBeApplication.class, args);
		log.info("STARTED ------------------->");
//		https://www.youtube.com/watch?v=j0Hnhb-SUo4&list=PLgYFT7gUQL8GUoIDh1p8FDXCmImzVVbRi&index=5
		// NEXT continue to BEw
	}

}
