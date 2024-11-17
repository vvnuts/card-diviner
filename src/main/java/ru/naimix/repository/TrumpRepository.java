package ru.naimix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naimix.domain.entity.Trump;

public interface TrumpRepository extends JpaRepository<Trump, Long> {
}
