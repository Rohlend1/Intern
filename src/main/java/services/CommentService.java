package services;

import models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public Comment findById(int id){
        return commentRepository.findById(id);
    }

    public void save(Comment comment){
        commentRepository.save(comment);
    }

    public void delete(Comment comment){
        commentRepository.delete(comment);
    }

    public void update(int id, Comment comment){
        commentRepository.delete(commentRepository.findById(id));
        comment.setId(id);
        commentRepository.save(comment);
    }
}
