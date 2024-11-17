package ru.naimix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naimix.domain.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}