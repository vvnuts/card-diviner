package ru.naimix.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.naimix.domain.entity.Characteristic;
import ru.naimix.domain.entity.CharacteristicCompany;
import ru.naimix.mapper.CharacteristicCompanyMapper;
import ru.naimix.mapper.CharacteristicMapper;
import ru.naimix.mapper.QuestionMapper;
import ru.naimix.model.CharacteristicCompanyRequest;
import ru.naimix.model.CharacteristicCompanyResponse;
import ru.naimix.model.CharacteristicValueRequest;
import ru.naimix.model.CharacteristicsResponse;
import ru.naimix.repository.CharacteristicCompanyRepository;
import ru.naimix.repository.CharacteristicRepository;
import ru.naimix.service.CharacteristicCompanyService;
import ru.naimix.service.CharacteristicService;
import ru.naimix.service.CompanyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CharacteristicServiceImpl implements CharacteristicService {
    private final CharacteristicRepository characteristicRepository;
    private final CharacteristicMapper characteristicMapper;
    private final QuestionMapper questionMapper;
    private final CompanyService companyService;
    private final CharacteristicCompanyService characteristicCompanyService;
    private final CharacteristicCompanyRepository characteristicCompanyRepository;
    private final CharacteristicCompanyMapper characteristicCompanyMapper;
    @Override
    @Transactional(readOnly = true)
    public CharacteristicsResponse getCharacteristicsResponse() {
        var characteristicFromRepository = characteristicRepository.findAll();

        var characteristicForResponse = characteristicFromRepository.stream()
                .map(
                        characteristic -> {
                            var characteristicResponse = characteristicMapper.toCharacteristicResponse(characteristic);
                            characteristicResponse.setQuestions(questionMapper.toQuestionResponseList(characteristic.getQuestions()));
                            return characteristicResponse;
                        }
                ).toList();

        var characteristicsResponse = new CharacteristicsResponse();
        characteristicsResponse.content(characteristicForResponse);
        return characteristicsResponse;
    }

    @Override
    @Transactional
    public CharacteristicCompanyResponse addCharacteristicToCompany(Long characteristicId, Long companyId, CharacteristicCompanyRequest characteristicCompanyRequest) {
        var characteristicFromRepository = characteristicRepository.findById(characteristicId)
                .orElseThrow(() -> new IllegalArgumentException("Характеристика не найдена в БД"));
        var companyForResponse = companyService.findCompanyById(companyId);
        return characteristicCompanyService.create(characteristicFromRepository, companyForResponse, characteristicCompanyRequest);
    }

    @Override
    public List<CharacteristicCompanyResponse> addCharacteristicsToCompany(Long companyId, CharacteristicValueRequest characteristicValueRequest) {
        var companyFromRepo = companyService.findCompanyById(companyId);
        Map<Integer, Integer> characteristicIdValue = new HashMap<>();
        for (int i = 0; i < characteristicValueRequest.getValues().size(); i++) {
            characteristicIdValue.put(characteristicValueRequest.getIds().get(i), characteristicValueRequest.getValues().get(i));
        }
        List<CharacteristicCompany> characteristicCompanyValues = characteristicCompanyService.findByCompany(companyFromRepo);
        if (characteristicCompanyValues == null || characteristicCompanyValues.isEmpty()) {
            List<Characteristic> characteristics = characteristicIdValue.keySet().stream().map(
                    id -> characteristicRepository.findById(id.longValue())
                            .orElseThrow(() -> new IllegalArgumentException("Характеристика не найдена в БД"))
            ).toList();
            List<CharacteristicCompany> list = characteristics.stream().map(characteristic -> {
                CharacteristicCompany create = new CharacteristicCompany();
                create.setCharacteristic(characteristic);
                create.setCompany(companyFromRepo);
                create.setValue(characteristicIdValue.get(characteristic.getId().intValue()));
                return characteristicCompanyRepository.saveAndFlush(create);
            }).toList();
            return characteristicCompanyMapper.toCharacteristicCompanyResponseList(list);
        }
        characteristicCompanyValues.forEach(characteristicCompany -> {
            characteristicCompany.setValue(characteristicIdValue.get(characteristicCompany.getCharacteristic().getId().intValue()));
            characteristicCompanyRepository.saveAll(characteristicCompanyValues);
        });
        return characteristicCompanyMapper.toCharacteristicCompanyResponseList(characteristicCompanyValues);
    }
}
