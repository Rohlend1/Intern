package com.senlainc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"com.senlainc.services","com.senlainc.repositories"})
public class SpringConfig {

}
