package com.senlainc.controllers;

import com.senlainc.dto.comments.CommentDto;
import com.senlainc.dto.comments.ParentCommentAndReviewSearchDto;
import com.senlainc.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/all")
    public List<CommentDto> getComments(){
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public CommentDto getComment(@PathVariable("id") int id){
        return commentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable("id") int id){
        commentService.delete(id);
    }

    @PutMapping
    public void saveOrUpdateComment(@RequestBody CommentDto commentDTO){
        commentService.saveOrUpdate(commentDTO);
    }

    @GetMapping("/find/parent-comment")
    public List<CommentDto> getCommentByParentCommentAndReviewEquals(@RequestBody ParentCommentAndReviewSearchDto dto){
        return commentService.findByParentCommentEqualsAndReviewEquals(dto.getParentComment(), dto.getReview());
    }

    @GetMapping("/find/most-popular")
    public CommentDto getMostPopularComment(){
        return commentService.findById(commentService.findIdMostPopularComment());
    }

    @GetMapping("/find/parent-comment/sorted")
    public List<CommentDto> getCommentByParentCommentSortedASC(@RequestBody CommentDto dto){
        return commentService.findByParentCommentSortedASC(dto);
    }
}
