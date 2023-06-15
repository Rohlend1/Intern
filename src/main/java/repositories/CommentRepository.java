package repositories;

import models.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {

    private List<Comment> comments;

    public List<Comment> findAll() {
        return comments;
    }

    public void save(Comment comment) {
        comments.add(comment);
    }

    public Comment findOne(Comment comment){
        return comments.stream().filter(a->a.equals(comment)).findAny().orElse(null);
    }

    public Comment findById(int id){
        return comments.stream().filter(a->a.getId()==id).findAny().orElse(null);
    }

    public void delete(Comment comment){
        comments.remove(comment);
    }

}
