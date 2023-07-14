package com.senlainc.util.mappers;

import com.senlainc.dto.reviews.ReviewDTO;
import com.senlainc.models.Review;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDTO toDTO(Review Review);
    Review toEntity(ReviewDTO ReviewDTO);
    List<Review> toEntityList(List<ReviewDTO> ReviewDTOs);
    List<ReviewDTO> toDTOList(List<Review> Review);
}
