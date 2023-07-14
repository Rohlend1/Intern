package com.senlainc.util.mappers;

import com.senlainc.dto.subscribes.SubscribeDto;
import com.senlainc.models.Subscribe;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscribeMapper {
    SubscribeDto toDTO(Subscribe Subscribe);
    Subscribe toEntity(SubscribeDto SubscribeDTO);
    List<Subscribe> toEntityList(List<SubscribeDto> subscribeDtos);
    List<SubscribeDto> toDTOList(List<Subscribe> Subscribe);
}
