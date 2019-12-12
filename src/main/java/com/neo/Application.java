package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@ServletComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class Application extends WebMvcConfigurationSupport{


    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(true).setUseTrailingSlashMatch(true);
    }


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
