package com.senlainc.controllers;

import com.senlainc.dto.comments.CommentDTO;
import com.senlainc.dto.comments.ParentCommentAndReviewSearchDTO;
import com.senlainc.services.CommentService;
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
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public CommentDTO getComment(@PathVariable("id") int id){
        return commentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable("id") int id){
        commentService.delete(id);
    }

    @PatchMapping
    public void updateComment(@RequestBody CommentDTO commentDTO){
        commentService.saveOrUpdate(commentDTO);
    }

    @PostMapping
    public void createComment(@RequestBody CommentDTO commentDTO){
        commentService.saveOrUpdate(commentDTO);
    }

    @GetMapping("/parent_review")
    public List<CommentDTO> getCommentByParentCommentAndReviewEquals(@RequestBody ParentCommentAndReviewSearchDTO dto){
        return commentService.findByParentCommentEqualsAndReviewEquals(dto.getParentComment(), dto.getReview());
    }

    @GetMapping("/most_popular")
    public CommentDTO getMostPopularComment(){
        return commentService.findById(commentService.findIdMostPopularComment());
    }

    @GetMapping("/parent_sorted")
    public List<CommentDTO> getCommentByParentCommentSortedASC(@RequestBody CommentDTO dto){
        return commentService.findByParentCommentSortedASC(dto);
    }
}
