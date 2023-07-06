package com.senlainc.util;

import com.senlainc.models.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DatabasePreparer {

    public static List<User> users = new ArrayList<>();
    public static List<Actor> actors = new ArrayList<>();
    public static List<FilmCompany> filmCompanies = new ArrayList<>();
    public static List<Subscribe> subscribes = new ArrayList<>();
    public static List<Review> reviews = new ArrayList<>();
    public static List<Comment> comments = new ArrayList<>();
    public static List<Comment> replies = new ArrayList<>();
    public static List<Movie> movies = new ArrayList<>();
    public static List<Genre> genres = new ArrayList<>();


    public static void prepareDatabase(AnnotationConfigApplicationContext context){

        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
        EntityManager em = emf.createEntityManager();

        Actor actor1 = new Actor("Paul","Walker", Gender.MALE,"USA", LocalDate.now(),40,new ArrayList<>());
        Actor actor2 = new Actor("Jim","Carry", Gender.MALE,"USA", LocalDate.now(),58,new ArrayList<>());
        Actor actor3 = new Actor("Megan","Fox", Gender.FEMALE,"China", LocalDate.now(),33,new ArrayList<>());
        Actor actor4 = new Actor("Steven","Rogers", Gender.MALE,"Canada", LocalDate.now(),35,new ArrayList<>());
        Actor actor5 = new Actor("Keanu","Reeves", Gender.MALE,"Russia", LocalDate.now(),48,new ArrayList<>());

        User user1 = new User("Ark", new ArrayList<>());
        User user2 = new User("Smile", new ArrayList<>());
        User user3 = new User("Frog", new ArrayList<>());
        User user4 = new User("Axe", new ArrayList<>());
        User user5 = new User("Punisher!", new ArrayList<>());

//        Subscribe subscribe1 = new Subscribe();
//        Subscribe subscribe2 = new Subscribe();
//        Subscribe subscribe3 = new Subscribe();
//
//        SubscribeId subscribeId1 = new SubscribeId();
//        SubscribeId subscribeId2 = new SubscribeId();
//        SubscribeId subscribeId3 = new SubscribeId();

        Review review1 = new Review("Super",LocalDateTime.of(2018, Month.JANUARY,1,1,15),null,user1);
        Review review2 = new Review("It was so boring",LocalDateTime.of(2017, Month.JUNE,4,21,11),LocalDateTime.now(),user1);
        Review review3 = new Review("Worst movie I've ever seen",LocalDateTime.of(2019, Month.FEBRUARY,24,18,47),null,user3);
        Review review4 = new Review("Yeah, it was amazing",LocalDateTime.of(2016, Month.AUGUST,16,13,9),LocalDateTime.now(),user5);

        Comment comment1 = new Comment("Wow", LocalDateTime.of(2023, Month.JANUARY,1,1,15),null,user1,review1,null);
        Comment comment2 = new Comment("Awesome", LocalDateTime.of(2021, Month.DECEMBER,27,14,38),LocalDateTime.now(),user1,review1,null);
        Comment comment3 = new Comment("So bad", LocalDateTime.of(2020, Month.NOVEMBER,17,18,59),LocalDateTime.now(),user4,review1,null);
        Comment comment4 = new Comment("Disgusting", LocalDateTime.of(2020, Month.SEPTEMBER,21,1,15),LocalDateTime.now(),user2,review2,null);
        Comment comment5 = new Comment("Great", LocalDateTime.of(2021, Month.OCTOBER,19,23,47),LocalDateTime.now(),user4,review3,null);
        Comment comment6 = new Comment("Terrible", LocalDateTime.of(2022, Month.JULY,10,17,23),LocalDateTime.now(),user3,review4,null);

        FilmCompany filmCompany1 = new FilmCompany("WB",new ArrayList<>(),LocalDate.of(1960,Month.APRIL,15));
        FilmCompany filmCompany2 = new FilmCompany("21 Century",new ArrayList<>(),LocalDate.of(1899,Month.DECEMBER,25));
        FilmCompany filmCompany3 = new FilmCompany("Blumhouse",new ArrayList<>(),LocalDate.of(1999,Month.JANUARY,30));

        Movie movie1 = new Movie("Fast and furious",new ArrayList<>(),LocalDate.of(1980,Month.DECEMBER,20),filmCompany1,120,2_000_000,new ArrayList<>());
        Movie movie2 = new Movie("The mask",new ArrayList<>(),LocalDate.of(2007,Month.OCTOBER,12),filmCompany2,105,35_000_000,new ArrayList<>());
        Movie movie3 = new Movie("Captain America",new ArrayList<>(),LocalDate.of(2013,Month.JULY,8),filmCompany3,110,400_000_000,new ArrayList<>());
        Movie movie4 = new Movie("MOCK1",new ArrayList<>(),LocalDate.now(),filmCompany1,110,400_000_000,new ArrayList<>());
        Movie movie5 = new Movie("MOCK2",new ArrayList<>(),LocalDate.now(),filmCompany2,110,400_000_000,new ArrayList<>());

        Genre genre1 = new Genre("Action",new ArrayList<>());
        Genre genre2 = new Genre("Romance",new ArrayList<>());
        Genre genre3 = new Genre("Drama",new ArrayList<>());
        Genre genre4 = new Genre("Horror",new ArrayList<>());

        Comment reply1 = new Comment("Agree",LocalDateTime.of(2023, Month.APRIL,28,12,20),null,user3,comment1.getReview(),comment1);
        Comment reply2 = new Comment("I'm not advise this",LocalDateTime.of(2023, Month.APRIL,28,8,25),LocalDateTime.of(2023, Month.APRIL,30,12,20),user1,comment2.getReview(),comment2);
        Comment reply3 = new Comment("Of course -_-",LocalDateTime.of(2023, Month.MARCH,16,11,40),LocalDateTime.of(2023, Month.MAY,10,2,58),user4,comment1.getReview(),comment1);
        Comment reply4 = new Comment("Yeah, u re right",LocalDateTime.of(2023, Month.APRIL,28,12,20),LocalDateTime.of(2023, Month.JANUARY,28,12,20),user5,comment1.getReview(),comment1);
        Comment reply5 = new Comment("I give it an 8 out of 10",LocalDateTime.now(),LocalDateTime.now(),user2,comment3.getReview(),comment3);
        Comment reply6 = new Comment("Сomplete stupidity",LocalDateTime.of(2023, Month.APRIL,28,12,20),null,user2,comment4.getReview(),comment4);
        Comment reply7 = new Comment("It's a masterpiece",LocalDateTime.of(2023, Month.JUNE,12,14,14),null,user3,comment5.getReview(),comment5);
        Comment reply8 = new Comment("The truth",LocalDateTime.now(),null,user3,comment6.getReview(),comment6);

        em.getTransaction().begin();

        user1.getReviews().add(review1);
        user1.getReviews().add(review2);
        user3.getReviews().add(review3);
        user5.getReviews().add(review4);

        movie1.getActors().add(actor1);
        movie1.getActors().add(actor2);
        movie1.getActors().add(actor3);


        movie2.getActors().add(actor2);
        movie2.getActors().add(actor3);
        movie2.getActors().add(actor4);
        movie2.getActors().add(actor5);

        movie3.getActors().add(actor1);
        movie3.getActors().add(actor2);
        movie3.getActors().add(actor3);
        movie3.getActors().add(actor4);
        movie3.getActors().add(actor5);

        movie4.getActors().add(actor1);

        movie5.getActors().add(actor1);

        actor1.getMovies().add(movie1);
        actor1.getMovies().add(movie3);
        actor1.getMovies().add(movie4);
        actor1.getMovies().add(movie5);

        actor2.getMovies().add(movie1);
        actor2.getMovies().add(movie2);
        actor2.getMovies().add(movie3);

        actor3.getMovies().add(movie1);
        actor3.getMovies().add(movie2);
        actor3.getMovies().add(movie3);

        actor4.getMovies().add(movie2);
        actor4.getMovies().add(movie3);

        actor5.getMovies().add(movie2);
        actor5.getMovies().add(movie3);

        filmCompany2.getMovies().add(movie1);
        filmCompany1.getMovies().add(movie2);
        filmCompany3.getMovies().add(movie3);

        genre1.getMovies().add(movie1);
        genre1.getMovies().add(movie2);

        genre2.getMovies().add(movie1);
        genre2.getMovies().add(movie2);
        genre2.getMovies().add(movie3);

        genre3.getMovies().add(movie2);
        genre3.getMovies().add(movie3);

        genre4.getMovies().add(movie1);
        genre4.getMovies().add(movie3);

        movie1.getGenres().add(genre1);
        movie1.getGenres().add(genre2);
        movie1.getGenres().add(genre4);

        movie2.getGenres().add(genre1);
        movie2.getGenres().add(genre2);
        movie2.getGenres().add(genre3);

        movie3.getGenres().add(genre2);
        movie3.getGenres().add(genre3);
        movie3.getGenres().add(genre4);

        em.persist(actor1);
        em.persist(actor2);
        em.persist(actor3);
        em.persist(actor4);
        em.persist(actor5);

        em.persist(user1);
        em.persist(user2);
        em.persist(user3);
        em.persist(user4);
        em.persist(user5);

        em.persist(review1);
        em.persist(review2);
        em.persist(review3);
        em.persist(review4);

        em.persist(comment1);
        em.persist(comment2);
        em.persist(comment3);
        em.persist(comment4);
        em.persist(comment5);
        em.persist(comment6);

        em.persist(movie1);
        em.persist(movie2);
        em.persist(movie3);
        em.persist(movie4);
        em.persist(movie5);

        em.persist(genre1);
        em.persist(genre2);
        em.persist(genre3);
        em.persist(genre4);

        em.persist(reply1);
        em.persist(reply2);
        em.persist(reply3);
        em.persist(reply4);
        em.persist(reply5);
        em.persist(reply6);
        em.persist(reply7);
        em.persist(reply8);

        em.persist(filmCompany1);
        em.persist(filmCompany2);
        em.persist(filmCompany3);

//        subscribeId1.setSubscribedTo(user1.getId());
//        subscribeId1.setSubscriber(user2.getId());
//
//        subscribeId2.setSubscribedTo(user1.getId());
//        subscribeId2.setSubscriber(user3.getId());
//
//        subscribeId3.setSubscribedTo(user2.getId());
//        subscribeId3.setSubscriber(user3.getId());
//
//        subscribe1.setId(subscribeId1);
//        subscribe2.setId(subscribeId2);
//        subscribe3.setId(subscribeId3);
//
//        em.persist(subscribe1);
//        em.persist(subscribe2);
//        em.persist(subscribe3);

        em.getTransaction().commit();

        actors.addAll(List.of(actor1,actor2,actor3,actor4,actor5));
        movies.addAll(List.of(movie1,movie2,movie3,movie4,movie5));
        users.addAll(List.of(user1,user2,user3,user4,user5));
        filmCompanies.addAll(List.of(filmCompany1,filmCompany2,filmCompany3));
//        subscribes.addAll(List.of(subscribe1,subscribe2,subscribe3));
        comments.addAll(List.of(comment1,comment2,comment3,comment4,comment5,comment6));
        replies.addAll(List.of(reply1,reply2,reply3,reply4,reply5,reply6,reply7,reply8));
        reviews.addAll(List.of(review1,review2,review3,review4));
        genres.addAll(List.of(genre1,genre2,genre3,genre4));
    }

    public static void clearDatabase(AnnotationConfigApplicationContext context){
        EntityManager em = context.getBean(EntityManagerFactory.class).createEntityManager();
        em.getTransaction().begin();

        em.createNativeQuery("TRUNCATE Actor CASCADE;"+
                "TRUNCATE Movie CASCADE;" +
                "TRUNCATE Genre CASCADE;" +
                "TRUNCATE film_company CASCADE;" +
                "TRUNCATE Subscribe CASCADE;" +
                "TRUNCATE Comment CASCADE;" +
                "TRUNCATE Review CASCADE;" +
                "TRUNCATE users CASCADE;").executeUpdate();

        em.getTransaction().commit();
    }
}
