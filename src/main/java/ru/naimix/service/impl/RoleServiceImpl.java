package ru.naimix.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.naimix.mapper.RoleMapper;
import ru.naimix.model.RolesResponse;
import ru.naimix.repository.RoleRepository;
import ru.naimix.service.RoleService;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    @Override
    @Transactional(readOnly = true)
    public RolesResponse getRolesResponse() {
        var roles = roleRepository.findAll();
        var rolesResponse = roleMapper.toRoleResponseList(roles);
        var rolesForResponse = new RolesResponse();
        rolesForResponse.content(rolesResponse);
        return rolesForResponse;
    }
}
