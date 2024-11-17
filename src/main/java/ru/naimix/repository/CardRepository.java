package ru.naimix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naimix.domain.entity.Card;

import java.util.Collection;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
}