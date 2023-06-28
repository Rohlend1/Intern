package com.senlainc.repositories;

import com.senlainc.errors.ModelNotFoundException;
import com.senlainc.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public List<User> findAll() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }

    public User findOne(User user){
        return users.stream().filter(a->a.equals(user)).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public User findById(int id){
        return users.stream().filter(a->a.getId()==id).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public void delete(User user){
        users.remove(user);
    }
}
