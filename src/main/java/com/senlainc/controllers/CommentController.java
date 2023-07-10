package com.senlainc.controllers;

import com.senlainc.dto.comments.CommentDTO;
import com.senlainc.dto.comments.ParentCommentAndReviewSearchDTO;
import com.senlainc.errors.ModelNotFoundException;
import com.senlainc.models.Comment;
import com.senlainc.services.CommentService;
import com.senlainc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<CommentDTO> getComments(){
        return Converter.convertListToCommentDTO(commentService.findAll());
    }

    @GetMapping("/{id}")
    public CommentDTO getComment(@PathVariable("id") int id){
        return Converter.convertToCommentDTO(commentService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable("id") int id){
        try{
            Comment comment = commentService.findById(id);
            commentService.delete(comment);
        }
        catch (ModelNotFoundException e){
            System.out.println("No comment with this id was found");
        }
    }

    @PatchMapping
    public void updateComment(CommentDTO commentDTO){
        commentService.saveOrUpdate(Converter.convertToComment(commentDTO));
    }

    @PostMapping
    public void createComment(CommentDTO commentDTO){
        commentService.saveOrUpdate(Converter.convertToComment(commentDTO));
    }

    @GetMapping("/parent_review")
    public List<CommentDTO> getCommentByParentCommentAndReviewEquals(@RequestBody ParentCommentAndReviewSearchDTO dto){
        Comment parentComment = Converter.convertToComment(dto.getParentComment());
        return Converter.convertListToCommentDTO(commentService.findByParentCommentEqualsAndReviewEquals(parentComment, dto.getReview()));
    }

    @GetMapping("/most_popular")
    public CommentDTO getMostPopularComment(){
        return Converter.convertToCommentDTO(commentService.findById(commentService.findIdMostPopularComment()));
    }

    @GetMapping("/parent_sorted")
    public List<CommentDTO> getCommentByParentCommentSortedASC(@RequestBody CommentDTO dto){
        Comment comment = Converter.convertToComment(dto);
        return Converter.convertListToCommentDTO(commentService.findByParentCommentSortedASC(comment));
    }
}
