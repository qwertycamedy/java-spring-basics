package com.qwertycamedy.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.qwertycamedy.spring")
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

}
