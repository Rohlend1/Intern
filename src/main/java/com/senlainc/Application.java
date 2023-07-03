package com.senlainc;

import com.senlainc.config.SpringConfig;
import com.senlainc.models.Actor;
import com.senlainc.services.*;
import com.senlainc.util.Gender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;


public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ActorService actorService = context.getBean(ActorService.class);

        Actor actor = new Actor("a","n", Gender.MALE,"c", LocalDate.now(),20,new ArrayList<>());

        actorService.save(actor);
    }
}
