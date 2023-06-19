package services;

import models.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.SubscribeRepository;

import java.util.List;

@Service
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;

    @Autowired
    public SubscribeService(SubscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }

    public List<Subscribe> findAll(){
        return subscribeRepository.findAll();
    }

    public Subscribe findById(int id){
        return subscribeRepository.findById(id);
    }

    public void save(Subscribe subscribe){
        subscribeRepository.save(subscribe);
    }

    public void delete(Subscribe subscribe){
        subscribeRepository.delete(subscribe);
    }

    public void update(int id, Subscribe subscribe){
        subscribeRepository.delete(subscribeRepository.findById(id));
        subscribe.setId(id);
        subscribeRepository.save(subscribe);
    }
}
