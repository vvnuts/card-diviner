package ru.naimix.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.naimix.domain.entity.Card;
import ru.naimix.repository.CardRepository;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardImporter {
    private final CardRepository cardRepository;

    @SneakyThrows
    @PostConstruct
    public void loadCardsFromJson() {
        var filePath = "src/main/resources/static/card_data.json";
        var objectMapper = new ObjectMapper();
        var tarotCards = objectMapper.readValue(new File(filePath), new TypeReference<List<Card>>() {});
        cardRepository.saveAll(tarotCards);
    }
}
