package com.senlainc.util.mappers;

import com.senlainc.dto.users.UserDto;
import com.senlainc.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDTO(User User);
    User toEntity(UserDto UserDTO);
    List<User> toEntityList(List<UserDto> userDtos);
    List<UserDto> toDTOList(List<User> User);
}
