package ru.naimix.service;

import ru.naimix.domain.entity.Card;
import ru.naimix.model.CardsResponse;

import java.util.Collection;
import java.util.List;

public interface CardService {
    CardsResponse getAllCards();
    List<Card> getCardsById(Collection<Long> ids);
}
