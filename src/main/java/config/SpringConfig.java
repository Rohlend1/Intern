package config;

import models.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositories.UserRepository;
import services.UserService;

@Configuration
public class SpringConfig {

    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository(){
        return new UserRepository();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = context.getBean("userService", UserService.class);

        User user1 = new User("John");
        User user2 = new User("Tom");
        User user3 = new User("Bob");

        user1.setId(1);
        user2.setId(2);
        user3.setId(3);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);


        System.out.println(userService.findAll());

        System.out.println(userService.findById(1));

        userService.update(1,new User("Jerry"));

        System.out.println(userService.findById(1));

        userService.delete(user2);

        System.out.println(userService.findAll());
    }
}
