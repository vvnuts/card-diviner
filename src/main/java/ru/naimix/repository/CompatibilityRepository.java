package ru.naimix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naimix.domain.entity.Compatibility;

public interface CompatibilityRepository extends JpaRepository<Compatibility, Long> {

}
