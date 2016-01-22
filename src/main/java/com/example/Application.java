package com.example;

import com.example.config.JpaConfig;
import com.example.repository.DataRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages="com.example", entityManagerFactoryRef="configureEntityManagerFactory")
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(new Class<?>[] {Application.class, JpaConfig.class}, args);
		ConfigurableApplicationContext context = SpringApplication.run(Application.class);
		DataRepository repository = context.getBean(DataRepository.class);


	}
}
