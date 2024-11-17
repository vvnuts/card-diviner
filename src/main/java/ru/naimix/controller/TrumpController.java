package ru.naimix.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.naimix.facade.TrumpFacade;
import ru.naimix.model.TrumpRequest;
import ru.naimix.model.TrumpResponse;
import ru.naimix.model.TrumpsResponse;
import ru.naimix.service.TrumpService;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/trumps")
@RequiredArgsConstructor
public class TrumpController {
    private final TrumpFacade trumpFacade;
    private final TrumpService trumpService;

    @PostMapping
    public ResponseEntity<TrumpResponse> createTrump(@RequestBody TrumpRequest trumpRequest){
        var trumpForResponse = trumpFacade.create(trumpRequest);
        return new ResponseEntity<>(trumpForResponse, OK);
    }

    @GetMapping("/all")
    public ResponseEntity<TrumpsResponse> getAllTrumps() {
        var trumpsResponse = trumpService.getAllTrumps();
        return new  ResponseEntity<>(trumpsResponse, OK);
    }
}
