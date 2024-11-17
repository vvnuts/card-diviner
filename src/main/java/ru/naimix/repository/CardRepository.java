package ru.naimix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naimix.domain.entity.Card;

public interface CardRepository extends JpaRepository<Card, String> {
}