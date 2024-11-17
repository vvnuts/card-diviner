package ru.naimix.service;

import ru.naimix.model.CharacteristicCompanyRequest;
import ru.naimix.model.CharacteristicCompanyResponse;
import ru.naimix.model.CharacteristicsResponse;

public interface CharacteristicService {
    CharacteristicsResponse getCharacteristicsResponse();

    CharacteristicCompanyResponse addCharacteristicToCompany(
            Long characteristicId,
            Long companyId,
            CharacteristicCompanyRequest characteristicCompanyRequest
    );
}
