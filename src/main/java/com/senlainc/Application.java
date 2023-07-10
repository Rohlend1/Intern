package com.senlainc;

import com.senlainc.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    }
}
