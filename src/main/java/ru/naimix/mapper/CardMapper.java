package ru.naimix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.naimix.domain.entity.Card;
import ru.naimix.model.CardResponse;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CardMapper {
    CardResponse toCardResponse(Card card);
    List<CardResponse> toCardResponseList(List<Card> cards);
}
