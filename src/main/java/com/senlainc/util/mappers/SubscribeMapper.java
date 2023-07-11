package com.senlainc.util.mappers;

import com.senlainc.dto.subscribes.SubscribeDTO;
import com.senlainc.models.Subscribe;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscribeMapper {
    SubscribeDTO toDTO(Subscribe Subscribe);
    Subscribe toEntity(SubscribeDTO SubscribeDTO);
    List<Subscribe> toEntityList(List<SubscribeDTO> SubscribeDTOs);
    List<SubscribeDTO> toDTOList(List<Subscribe> Subscribe);
}
