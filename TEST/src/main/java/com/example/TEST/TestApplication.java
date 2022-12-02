package com.example.TEST;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableScheduling
//@EnableSwagger2
@EnableWebMvc
@SpringBootApplication(scanBasePackages = "com.example")
public class TestApplication implements ApplicationRunner{
	
	@Value("${hello}")
	String name;
	
	@Scheduled(fixedRate = 1000)
	public void nam() {
		
		System.out.println(System.currentTimeMillis());
	}
	
	@RequestMapping("/")
	public String name() {
		return "Hello ragavan";
	}
	private static final org.slf4j.Logger logg=LoggerFactory.getLogger(TestApplication.class);
	
	public static void main(String[] args) {
		logg.warn("Hello");
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Application Started"+" " +name);
		
	}
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.example.TEST")).build();
	   }

}
