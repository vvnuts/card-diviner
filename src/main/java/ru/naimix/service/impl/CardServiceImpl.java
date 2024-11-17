package ru.naimix.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.naimix.mapper.CardMapper;
import ru.naimix.model.CardsResponse;
import ru.naimix.repository.CardRepository;
import ru.naimix.service.CardService;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Override
    public CardsResponse getAllCards() {
        var cardsFromRepository = cardRepository.findAll();
        var cardsForResponse = cardMapper.toCardResponseList(cardsFromRepository);
        var cardsResponse = new CardsResponse();
        cardsResponse.content(cardsForResponse);
        return cardsResponse;
    }
}
