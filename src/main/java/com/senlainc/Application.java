package com.senlainc;

import com.senlainc.config.SpringConfig;
import com.senlainc.models.*;
import com.senlainc.models.SubscribeId;
import com.senlainc.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.senlainc.util.Gender;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        CommentService commentService = context.getBean(CommentService.class);

        System.out.println(commentService.findById(5));

        System.out.println(commentService.findAll());
    }
}
