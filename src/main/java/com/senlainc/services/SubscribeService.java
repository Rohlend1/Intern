package com.senlainc.services;

import com.senlainc.dto.subscribes.SubscribeDto;

import java.util.List;

public interface SubscribeService {
    List<SubscribeDto> findAll();

    SubscribeDto findById(Integer id);

    void saveOrUpdate(SubscribeDto subscribe);

    void delete(SubscribeDto subscribe);

    void delete(int id);
}
