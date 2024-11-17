package ru.naimix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naimix.domain.entity.Card;
import ru.naimix.domain.entity.CardValue;

import java.util.List;

public interface CardValueRepository extends JpaRepository<CardValue, Long> {
    List<CardValue> getAllByCard(Card card);
}
