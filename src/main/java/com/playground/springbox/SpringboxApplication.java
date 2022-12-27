package com.playground.springbox;

import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Sandbox",
				version = "0.1",
				description = "Testing different spring concepts in an isolated env"
		),
		servers = @Server(url = "/")
)
public class SpringboxApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringboxApplication.class, args);
	}

}
