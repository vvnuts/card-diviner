package ru.naimix.service;

import ru.naimix.model.CharacteristicCompanyRequest;
import ru.naimix.model.CharacteristicCompanyResponse;
import ru.naimix.model.CharacteristicValueRequest;
import ru.naimix.model.CharacteristicsResponse;

import java.util.List;

public interface CharacteristicService {
    CharacteristicsResponse getCharacteristicsResponse();

    CharacteristicCompanyResponse addCharacteristicToCompany(
            Long characteristicId,
            Long companyId,
            CharacteristicCompanyRequest characteristicCompanyRequest
    );

    List<CharacteristicCompanyResponse> addCharacteristicsToCompany(Long companyId,
                                                                    CharacteristicValueRequest characteristicValueRequest
    );
}
