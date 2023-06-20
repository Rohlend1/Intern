package repositories;

import errors.ModelNotFoundException;
import models.Actor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ActorRepository {
    private final List<Actor> actors = new ArrayList<>();

    public List<Actor> findAll() {
        return actors;
    }

    public void save(Actor actor) {
        actors.add(actor);
    }

    public Actor findOne(Actor actor){
        return actors.stream().filter(a->a.equals(actor)).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public Actor findById(int id){
        return actors.stream().filter(a->a.getId()==id).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public void delete(Actor actor){
        actors.remove(actor);
    }

}
