package ru.naimix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.naimix.domain.entity.Characteristic;
import ru.naimix.model.CharacteristicResponse;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CharacteristicMapper {
    CharacteristicResponse toCharacteristicResponse(Characteristic characteristic);
    List<CharacteristicResponse> toCharacteristicResponseList(List<Characteristic> characteristics);
}
