package ru.naimix.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.naimix.domain.entity.Characteristic;
import ru.naimix.domain.entity.CharacteristicCompany;
import ru.naimix.domain.entity.Company;
import ru.naimix.mapper.CharacteristicCompanyMapper;
import ru.naimix.model.CharacteristicCompanyRequest;
import ru.naimix.model.CharacteristicCompanyResponse;
import ru.naimix.model.CharacteristicResponse;
import ru.naimix.model.CompanyResponse;
import ru.naimix.repository.CharacteristicCompanyRepository;
import ru.naimix.repository.CharacteristicRepository;
import ru.naimix.service.CharacteristicCompanyService;

import java.util.List;

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

    @Override
    public CharacteristicCompany getCharacteristicCompanyBy(Characteristic characteristic, Company company) {
        return characteristicCompanyRepository.findByCharacteristicAndCompany(characteristic, company);
    }

    @Override
    public List<CharacteristicCompany> findByCompany(Company company) {
        return characteristicCompanyRepository.findAllByCompany(company);
    }
}
