package repositories;

import errors.ModelNotFoundException;
import models.Subscribe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubscribeRepository {

    private final List<Subscribe> subscribes = new ArrayList<>();

    public List<Subscribe> findAll() {
        return subscribes;
    }

    public void save(Subscribe subscribe) {
        subscribes.add(subscribe);
    }

    public Subscribe findOne(Subscribe subscribe){
        return subscribes.stream().filter(a->a.equals(subscribe)).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public Subscribe findById(int id){
        return subscribes.stream().filter(a->a.getId()==id).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public void delete(Subscribe subscribe){
        subscribes.remove(subscribe);
    }
}
