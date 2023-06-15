package repositories;

import models.Actor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActorRepository {
    private List<Actor> actors;

    public List<Actor> findAll() {
        return actors;
    }

    public void save(Actor actor) {
        actors.add(actor);
    }

    public Actor findOne(Actor actor){
        return actors.stream().filter(a->a.equals(actor)).findAny().orElse(null);
    }

    public Actor findById(int id){
        return actors.stream().filter(a->a.getId()==id).findAny().orElse(null);
    }

    public void delete(Actor actor){
        actors.remove(actor);
    }
}
