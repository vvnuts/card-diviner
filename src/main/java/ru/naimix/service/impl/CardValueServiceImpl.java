package ru.naimix.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.naimix.domain.entity.Card;
import ru.naimix.domain.entity.CardValue;
import ru.naimix.repository.CardValueRepository;
import ru.naimix.service.CardService;
import ru.naimix.service.CardValueService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardValueServiceImpl implements CardValueService {

    private final CardValueRepository repository;
    private final CardService service;

    @Override
    @Transactional(readOnly = true)
    public List<CardValue> getAllCardValueByCardsId(List<Long> ids) {
        List<Card> cards = service.getCardsById(ids);
        List<CardValue> cardValues = new ArrayList<>();
        cards.forEach(card -> {
            List<CardValue> allByCard = repository.getAllByCard(card);
            cardValues.addAll(allByCard);
        });
        return cardValues;
    }
}
