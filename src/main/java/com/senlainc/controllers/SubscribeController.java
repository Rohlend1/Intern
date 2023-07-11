package com.senlainc.controllers;

import com.senlainc.dto.subscribes.SubscribeDTO;
import com.senlainc.errors.ModelNotFoundException;
import com.senlainc.models.Subscribe;
import com.senlainc.services.SubscribeService;
import com.senlainc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscribes")
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;
    
    @Autowired
    private Converter converter;

    @GetMapping
    public List<SubscribeDTO> getSubscribes(){
        return converter.convertListToSubscribeDTO(subscribeService.findAll());
    }

    @GetMapping("/{id}")
    public SubscribeDTO getSubscribe(@PathVariable("id") int id){
        return converter.convertToSubscribeDTO(subscribeService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable("id") int id){
        try{
            Subscribe subscribe = subscribeService.findById(id);
            subscribeService.delete(subscribe);
        }
        catch (ModelNotFoundException e){
            System.out.println("No genre with this id was found");
        }
    }

    @PatchMapping
    public void updateSubscribe(SubscribeDTO subscribeDTO){
        subscribeService.saveOrUpdate(converter.convertToSubscribe(subscribeDTO));
    }

    @PostMapping
    public void createSubscribe(SubscribeDTO subscribeDTO){
        subscribeService.saveOrUpdate(converter.convertToSubscribe(subscribeDTO));
    }
}
