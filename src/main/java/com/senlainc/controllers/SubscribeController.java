package com.senlainc.controllers;

import com.senlainc.dto.subscribes.SubscribeDto;
import com.senlainc.services.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscribes")
public class SubscribeController {

    @Autowired
    private SubscribeService subscribeService;

    @GetMapping("/all")
    public List<SubscribeDto> getSubscribes() {
        return subscribeService.findAll();
    }

    @GetMapping("/{id}")
    public SubscribeDto getSubscribe(@PathVariable("id") int id) {
        return subscribeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable("id") int id) {
        subscribeService.delete(id);
    }

    @PutMapping
    public void saveOrUpdateSubscribe(@RequestBody SubscribeDto subscribeDTO) {
        subscribeService.saveOrUpdate(subscribeDTO);
    }
}
