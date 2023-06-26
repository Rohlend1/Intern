package com.senlainc.repositories;

import com.senlainc.errors.ModelNotFoundException;
import com.senlainc.models.Comment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentRepository {

    private final List<Comment> comments = new ArrayList<>();

    public List<Comment> findAll() {
        return comments;
    }

    public void save(Comment comment) {
        comments.add(comment);
    }

    public Comment findOne(Comment comment){
        return comments.stream().filter(a->a.equals(comment)).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public Comment findById(int id){
        return comments.stream().filter(a->a.getId()==id).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public void delete(Comment comment){
        comments.remove(comment);
    }

}
