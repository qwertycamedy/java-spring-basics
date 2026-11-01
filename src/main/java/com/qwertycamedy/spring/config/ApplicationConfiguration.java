package com.qwertycamedy.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//component scan позволяет нам прошерстить все подпакеты указанного пакета, чтобы выявить все компоненты, которые мы хотим дать спрингу (например компонент cat)
@ComponentScan("com.qwertycamedy.spring")
public class ApplicationConfiguration {

}
