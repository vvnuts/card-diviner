package ru.naimix.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.naimix.mapper.CharacteristicMapper;
import ru.naimix.model.CharacteristicCompanyRequest;
import ru.naimix.model.CharacteristicCompanyResponse;
import ru.naimix.model.CharacteristicsResponse;
import ru.naimix.repository.CharacteristicRepository;
import ru.naimix.service.CharacteristicCompanyService;
import ru.naimix.service.CharacteristicService;
import ru.naimix.service.CompanyService;

@Service
@RequiredArgsConstructor
public class CharacteristicServiceImpl implements CharacteristicService {
    private final CharacteristicRepository characteristicRepository;
    private final CharacteristicMapper characteristicMapper;
    private final CompanyService companyService;
    private final CharacteristicCompanyService characteristicCompanyService;
    @Override
    @Transactional(readOnly = true)
    public CharacteristicsResponse getCharacteristicsResponse() {
        var characteristicFromRepository = characteristicRepository.findAll();
        var characteristicForResponse = characteristicMapper.toCharacteristicResponseList(characteristicFromRepository);
        var characteristicsResponse = new CharacteristicsResponse();
        characteristicsResponse.content(characteristicForResponse);
        return characteristicsResponse;
    }

    @Override
    @Transactional
    public CharacteristicCompanyResponse addCharacteristicToCompany(Long characteristicId, Long companyId, CharacteristicCompanyRequest characteristicCompanyRequest) {
        var characteristicFromRepository = characteristicRepository.findById(characteristicId)
                .orElseThrow(() -> new IllegalArgumentException("Характеристика не найдена в БД"));
        var companyForResponse = companyService.getCompanyForCharacteristic(companyId);
        return characteristicCompanyService.create(characteristicFromRepository, companyForResponse, characteristicCompanyRequest);
    }
}
