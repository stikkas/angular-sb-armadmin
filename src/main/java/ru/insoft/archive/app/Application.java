package ru.insoft.archive.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("ru.insoft.archive.domain")
@EnableJpaRepositories("ru.insoft.archive.repo")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
