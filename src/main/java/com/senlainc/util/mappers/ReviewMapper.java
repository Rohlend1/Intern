package com.senlainc.util.mappers;

import com.senlainc.dto.reviews.ReviewDto;
import com.senlainc.models.Review;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDto toDTO(Review Review);
    Review toEntity(ReviewDto ReviewDTO);
    List<Review> toEntityList(List<ReviewDto> reviewDtos);
    List<ReviewDto> toDTOList(List<Review> Review);
}
