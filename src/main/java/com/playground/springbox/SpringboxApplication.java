package com.playground.springbox;

import com.playground.springbox.Constants.AppConstants;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = AppConstants.APP_TITLE,
				version = AppConstants.APP_VERSION,
				description = AppConstants.APP_DESCRIPTION
		),
		servers = @Server(url = AppConstants.APP_DEFAULT_URL)
)
public class SpringboxApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringboxApplication.class, args);
	}

}
