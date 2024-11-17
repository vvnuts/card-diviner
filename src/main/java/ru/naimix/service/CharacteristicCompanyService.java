package ru.naimix.service;

import ru.naimix.domain.entity.Characteristic;
import ru.naimix.domain.entity.CharacteristicCompany;
import ru.naimix.domain.entity.Company;
import ru.naimix.model.CharacteristicCompanyRequest;
import ru.naimix.model.CharacteristicCompanyResponse;

import java.util.List;

public interface CharacteristicCompanyService {
    CharacteristicCompanyResponse create(Characteristic characteristic, Company company, CharacteristicCompanyRequest characteristicCompanyRequest);

    CharacteristicCompany getCharacteristicCompanyBy(Characteristic characteristic, Company company);

    List<CharacteristicCompany> findByCompany(Company company);
}
