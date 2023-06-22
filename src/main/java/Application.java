import config.SpringConfig;
import models.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.UserService;
import util.Gender;

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
        Comment comment = new Comment("Wow", LocalDateTime.now(),LocalDateTime.now(),null,null,null);
        Review review = new Review("Super",LocalDateTime.now(),LocalDateTime.now(),null,comment);
        User user = new User("HH",new ArrayList<>(),new ArrayList<>());
        FilmCompany filmCompany = new FilmCompany("WB",new ArrayList<>(),LocalDate.now());
        Movie movie = new Movie("Fast and furious",new ArrayList<>(),LocalDate.now(),filmCompany,120,2_000_000,new ArrayList<>());
        Genre genre = new Genre("Action",new ArrayList<>());

        actor.getMovies().add(movie);
        review.setOwner(user);
        comment.setOwner(user);
        comment.setReply(comment);
        comment.setReview(review);
        user.getReviews().add(review);
        user.getComments().add(comment);
        filmCompany.getMovies().add(movie);
        movie.getGenres().add(genre);
        movie.getActors().add(actor);
        genre.getMovies().add(movie);

        em.getTransaction().begin();

        em.persist(actor);
        em.persist(review);
        em.persist(comment);
        em.persist(user);
        em.persist(filmCompany);
        em.persist(genre);
        em.persist(movie);

        em.getTransaction().commit();
    }
}
