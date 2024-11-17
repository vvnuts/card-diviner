package ru.naimix.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.naimix.domain.entity.Characteristic;
import ru.naimix.domain.entity.Company;
import ru.naimix.mapper.CharacteristicCompanyMapper;
import ru.naimix.model.CharacteristicCompanyRequest;
import ru.naimix.model.CharacteristicCompanyResponse;
import ru.naimix.model.CharacteristicResponse;
import ru.naimix.model.CompanyResponse;
import ru.naimix.repository.CharacteristicCompanyRepository;
import ru.naimix.repository.CharacteristicRepository;
import ru.naimix.service.CharacteristicCompanyService;
@Service
@RequiredArgsConstructor
public class CharacteristicCompanyServiceImpl implements CharacteristicCompanyService {
    private final CharacteristicCompanyRepository characteristicCompanyRepository;
    private final CharacteristicCompanyMapper characteristicCompanyMapper;


    @Override
    public CharacteristicCompanyResponse create(Characteristic characteristic, Company company, CharacteristicCompanyRequest characteristicCompanyRequest) {
        var characteristicForSave = characteristicCompanyMapper.toCharacteristicCompany(characteristic,
                company,
                characteristicCompanyRequest);
        var saveAndFlush = characteristicCompanyRepository.saveAndFlush(characteristicForSave);
        return characteristicCompanyMapper.toCharacteristicCompanyResponse(saveAndFlush);
    }
}
