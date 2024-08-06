package com.lorena.curso.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
    @PropertySources(
        @PropertySource("classpath:values.properties")
)
public class ValuesConfig {

}
