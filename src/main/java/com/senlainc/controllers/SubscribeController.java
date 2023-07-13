package com.senlainc.controllers;

import com.senlainc.dto.subscribes.SubscribeDTO;
import com.senlainc.services.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscribes")
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;

    @GetMapping
    public List<SubscribeDTO> getSubscribes(){
        return subscribeService.findAll();
    }

    @GetMapping("/{id}")
    public SubscribeDTO getSubscribe(@PathVariable("id") int id){
        return subscribeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable("id") int id){
        subscribeService.delete(id);
    }

    @PatchMapping
    public void updateSubscribe(@RequestBody SubscribeDTO subscribeDTO){
        subscribeService.saveOrUpdate(subscribeDTO);
    }

    @PostMapping
    public void createSubscribe(@RequestBody SubscribeDTO subscribeDTO){
        subscribeService.saveOrUpdate(subscribeDTO);
    }
}
