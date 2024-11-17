package ru.naimix.service;

import ru.naimix.domain.entity.CardValue;

import java.util.List;

public interface CardValueService {
    List<CardValue> getAllCardValueByCardsId(List<Long> ids);
}
