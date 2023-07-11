package com.senlainc.util.mappers;

import com.senlainc.dto.comments.CommentDTO;
import com.senlainc.models.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDTO toDTO(Comment Comment);
    Comment toEntity(CommentDTO CommentDTO);
    List<Comment> toEntityList(List<CommentDTO> CommentDTOs);
    List<CommentDTO> toDTOList(List<Comment> Comment);
}
