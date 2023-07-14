package com.senlainc.util.mappers;

import com.senlainc.dto.comments.CommentDto;
import com.senlainc.models.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDto toDTO(Comment Comment);
    Comment toEntity(CommentDto CommentDTO);
    List<Comment> toEntityList(List<CommentDto> commentDtos);
    List<CommentDto> toDTOList(List<Comment> Comment);
}
