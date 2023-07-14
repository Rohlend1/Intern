package com.senlainc.util.mappers;

import com.senlainc.dto.actors.ActorDto;
import com.senlainc.models.Actor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorDto toDTO(Actor actor);
    Actor toEntity(ActorDto actorDTO);
    List<Actor> toEntityList(List<ActorDto> actorDtos);
    List<ActorDto> toDTOList(List<Actor> actor);
}
