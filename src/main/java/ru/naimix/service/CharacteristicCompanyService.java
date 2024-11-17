package ru.naimix.service;

import ru.naimix.domain.entity.Characteristic;
import ru.naimix.domain.entity.Company;
import ru.naimix.model.CharacteristicCompanyRequest;
import ru.naimix.model.CharacteristicCompanyResponse;

public interface CharacteristicCompanyService {
    CharacteristicCompanyResponse create(Characteristic characteristic, Company company, CharacteristicCompanyRequest characteristicCompanyRequest);
}
