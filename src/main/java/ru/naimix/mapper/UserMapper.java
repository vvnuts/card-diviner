package ru.naimix.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.naimix.domain.entity.Role;
import ru.naimix.domain.entity.User;
import ru.naimix.model.UserDto;
import ru.naimix.model.UserRequest;
import ru.naimix.model.UserResponse;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface UserMapper {
    UserResponse toUserResponse(User user);
    List<UserResponse> toUserResponseList(List<User> users);
    UserDto toUserDto(User user);
    List<UserDto> toUserDtoList(List<User> users);
    User toUser(UserRequest userRequest);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User update(@MappingTarget User userFind, UserRequest userRequest);
}
