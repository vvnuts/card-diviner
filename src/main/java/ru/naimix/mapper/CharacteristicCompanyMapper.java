package ru.naimix.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.naimix.domain.entity.Characteristic;
import ru.naimix.domain.entity.CharacteristicCompany;
import ru.naimix.domain.entity.Company;
import ru.naimix.model.CharacteristicCompanyRequest;
import ru.naimix.model.CharacteristicCompanyResponse;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CharacteristicCompanyMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "characteristic", source = "characteristic")
    @Mapping(target = "company", source = "company")
    @Mapping(target = "value", source = "characteristicCompanyRequest.value")
    CharacteristicCompany toCharacteristicCompany(Characteristic characteristic, Company company, CharacteristicCompanyRequest characteristicCompanyRequest);
    CharacteristicCompanyResponse toCharacteristicCompanyResponse(CharacteristicCompany characteristicCompany);
}
