package ru.naimix.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.naimix.model.CardsResponse;
import ru.naimix.service.CardService;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping
    public ResponseEntity<CardsResponse> get() {
        var cardsResponse = cardService.getAllCards();
        return new ResponseEntity<>(cardsResponse, OK);
    }
}
