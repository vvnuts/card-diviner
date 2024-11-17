package ru.naimix.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.naimix.facade.TrumpFacade;
import ru.naimix.model.TrumpRequest;
import ru.naimix.model.TrumpResponse;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/trumps")
@RequiredArgsConstructor
public class TrumpController {
    private final TrumpFacade trumpFacade;

    @PostMapping
    public ResponseEntity<TrumpResponse> createTrump(@RequestBody TrumpRequest trumpRequest){
        var trumpForResponse = trumpFacade.create(trumpRequest);
        return new ResponseEntity<>(trumpForResponse, OK);
    }
}
