package ru.naimix.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.naimix.model.CharacteristicCompanyRequest;
import ru.naimix.model.CharacteristicCompanyResponse;
import ru.naimix.model.CharacteristicValueRequest;
import ru.naimix.model.CharacteristicsResponse;
import ru.naimix.service.CharacteristicService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/characteristics")
@RequiredArgsConstructor
public class CharacteristicController {
    private final CharacteristicService characteristicService;
    @GetMapping
    public ResponseEntity<CharacteristicsResponse> getCharacteristicsResponse(){
        return ResponseEntity.ok(characteristicService.getCharacteristicsResponse());
    }
    @PostMapping("/{characteristicId}/company/{companyId}")
    public ResponseEntity<CharacteristicCompanyResponse> addCharacteristicToCompany(@PathVariable("characteristicId") Long characteristicId,
                                                                                    @PathVariable("companyId") Long companyId,
                                                                                    @RequestBody CharacteristicCompanyRequest characteristicCompanyRequest){
        var characteristicCompanyResponse = characteristicService.addCharacteristicToCompany(
                characteristicId,
                companyId,
                characteristicCompanyRequest
        );
        return new ResponseEntity<>(characteristicCompanyResponse, OK);
    }

    @PostMapping("{companyId}")
    public ResponseEntity<List<CharacteristicCompanyResponse>> addCharacteristicsToCompany(@PathVariable("companyId") Long companyId,
                                                            @RequestBody CharacteristicValueRequest characteristicValueRequest){
        List<CharacteristicCompanyResponse> characteristicCompanyResponses = characteristicService.addCharacteristicsToCompany(companyId, characteristicValueRequest);
        return new ResponseEntity<>(characteristicCompanyResponses, OK);
    }
}
