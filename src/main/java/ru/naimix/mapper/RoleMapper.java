package ru.naimix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.naimix.domain.entity.Role;
import ru.naimix.model.RoleResponse;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    RoleResponse toRoleResponse(Role role);
    List<RoleResponse> toRoleResponseList(List<Role> roles);
}
