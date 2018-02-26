package com.refeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Operlication {
	public static void main(String[] args) {
		SpringApplication.run(Operlication.class, args);
	}
}
/*@SpringBootApplication
public class Operlication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Operlication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Operlication.class, args);
	}

}*/
