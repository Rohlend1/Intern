package com.senlainc.repositories;

import com.senlainc.models.Subscribe;

import java.util.List;

public interface SubscribeRepository {

    List<Subscribe> findAll();

    Subscribe findById(Integer id);

    void saveOrUpdate(Subscribe subscribe);

    void delete(int id);

    void delete(Subscribe subscribe);

}
