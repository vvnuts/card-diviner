package ru.naimix.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.naimix.domain.entity.*;
import ru.naimix.model.TrumpRequest;
import ru.naimix.model.TrumpResponse;
import ru.naimix.repository.CompatibilityRepository;
import ru.naimix.repository.TrumpRepository;
import ru.naimix.service.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TrumpFacade {
    private static final int PERCENT = 100;
    private static final int MAX_VALUE_CHARACTERISTIC = 10;
    private final UserService userService;
    private final CompanyService companyService;
    private final CharacteristicCompanyService characteristicCompanyService;
    private final CardService cardService;
    private final TrumpRepository trumpRepository;
    private final CompatibilityRepository compatibilityRepository;

    private final CardValueService cardValueService;

    public TrumpResponse create(TrumpRequest trumpRequest) {
        return trumpRequest.getIsCompany()
                ? processCreateTrumpWithCompany(trumpRequest)
                : processCreateTrumpWithoutCompany(trumpRequest);
    }

    private TrumpResponse processCreateTrumpWithCompany(TrumpRequest trumpRequest) {
        var userIdFromRequest = trumpRequest.getTargetToId();
        var userFromRepository = userService.getById(userIdFromRequest);
        var company = companyService.findCompanyById(trumpRequest.getTargetFromId());
        List<Card> cards = cardService.getCardsById(trumpRequest.getCards());
        List<CardValue> cardValues = cardValueService.getAllCardValueByCardsId(trumpRequest.getCards());

        Map<Characteristic, List<CardValue>> characteristicCardValueMap = new HashMap<>();
        cardValues.forEach(
                        cardValue -> {
                            if (characteristicCardValueMap.containsKey(cardValue.getCharacteristic())) {
                                characteristicCardValueMap.get(cardValue.getCharacteristic()).add(cardValue);
                            } else {
                                List<CardValue> temp = new ArrayList<>();
                                temp.add(cardValue);
                                characteristicCardValueMap.put(cardValue.getCharacteristic(), temp);
                            }
                        }
                );


        int maxValueCompany = 0;
        float maxUserValue = 0;
        List<Compatibility> compatibilities = new ArrayList<>();
        for (var entry : characteristicCardValueMap.entrySet()) {
            Compatibility compatibility = new Compatibility();
            compatibility.setCharacteristic(entry.getKey());
            
            int characteristicCompatibility = 0;
            for (var characteristicValue : entry.getValue()) {
                characteristicCompatibility += characteristicValue.getValue();
            }
            int valueCompany = characteristicCompanyService.getCharacteristicCompanyBy(entry.getKey(), company).getValue();
            maxValueCompany += valueCompany;
            var result = characteristicCompatibility / ((float) valueCompany * entry.getValue().size()) * PERCENT;
            maxUserValue += result / 10;
            
            compatibility.setCompatibility(Math.round(result));
            compatibilities.add(compatibility);
        }

        Trump trump = new Trump();
        var a = Math.abs(maxUserValue - maxValueCompany);
        var b = (characteristicCardValueMap.size() * MAX_VALUE_CHARACTERISTIC);
        var score = 100 - (a / b * PERCENT);
        trump.setScore(Math.round(score));
        trump.setUserTo(userFromRepository);
        trump.setCompanyFrom(company);
        trump.setDate(LocalDateTime.now());
        trump.setCards(cards);
        Trump savedTrump = trumpRepository.saveAndFlush(trump);

        compatibilities.forEach(compatibility -> {
            compatibility.setTrump(savedTrump);
            compatibilityRepository.saveAndFlush(compatibility);
        });

        TrumpResponse trumpResponse = new TrumpResponse();
        trumpResponse.setId(savedTrump.getId());
        trumpResponse.setScore(savedTrump.getScore());

        return trumpResponse;
    }

    private TrumpResponse processCreateTrumpWithoutCompany(TrumpRequest trumpRequest) {
        return null;
    }
}
