package com.senlainc.util.mappers;

import com.senlainc.dto.users.UserDTO;
import com.senlainc.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User User);
    User toEntity(UserDTO UserDTO);
    List<User> toEntityList(List<UserDTO> UserDTOs);
    List<UserDTO> toDTOList(List<User> User);
}
