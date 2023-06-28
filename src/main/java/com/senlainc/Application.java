package com.senlainc;

import com.senlainc.config.SpringConfig;
import com.senlainc.models.*;
import com.senlainc.util.SubscribeId;
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

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MovieProject");
        EntityManager em = emf.createEntityManager();

        Actor actor = new Actor("Paul","Walker", Gender.MALE,"USA", LocalDate.now(),40,new ArrayList<>());
        User user = new User("HH", new ArrayList<>());
        User user1 = new User("AA", new ArrayList<>());

        Subscribe subscribe = new Subscribe();
        SubscribeId subscribeId = new SubscribeId();
        subscribeId.setSubscribedTo(user1);
        subscribeId.setSubscriber(user);
        subscribe.setId(subscribeId);
        Comment comment = new Comment("Wow", LocalDateTime.now(),LocalDateTime.now(),user,null,null);
        Review review = new Review("Super",LocalDateTime.now(),LocalDateTime.now(),null);
        FilmCompany filmCompany = new FilmCompany("WB",new ArrayList<>(),LocalDate.now());
        Movie movie = new Movie("Fast and furious",new ArrayList<>(),LocalDate.now(),filmCompany,120,2_000_000,new ArrayList<>());
        Genre genre = new Genre("Action",new ArrayList<>());
        Comment reply = new Comment("a",LocalDateTime.now(),LocalDateTime.now(),user,null,null);
        actor.getMovies().add(movie);
        review.setOwner(user);
        comment.setReplyTo(reply);
        comment.setReview(review);
        user.getReviews().add(review);
        filmCompany.getMovies().add(movie);
        movie.getGenres().add(genre);
        movie.getActors().add(actor);
        genre.getMovies().add(movie);

        em.getTransaction().begin();

        em.persist(user1);
        em.persist(actor);
        em.persist(review);
        em.persist(comment);
        em.persist(user);
        em.persist(filmCompany);
        em.persist(genre);
        em.persist(movie);
        em.persist(subscribe);

        em.getTransaction().commit();

    }
}
