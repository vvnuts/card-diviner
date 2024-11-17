package ru.naimix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.naimix.domain.entity.User;
import ru.naimix.model.UserFilterRequest;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = """
            SELECT u.* FROM users u
            JOIN user_with_role ur ON u.id = ur.user_id
            JOIN role r ON ur.role_id = r.id
            WHERE (:roleName IS NULL OR LOWER(r.name) = LOWER(:roleName))
            """, nativeQuery = true)
    List<User> filter(@Param("roleName") String role);
}