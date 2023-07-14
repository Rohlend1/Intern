package com.senlainc.util.mappers;

import com.senlainc.dto.actors.ActorDTO;
import com.senlainc.models.Actor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorDTO toDTO(Actor actor);
    Actor toEntity(ActorDTO actorDTO);
    List<Actor> toEntityList(List<ActorDTO> actorDTOs);
    List<ActorDTO> toDTOList(List<Actor> actor);
}
