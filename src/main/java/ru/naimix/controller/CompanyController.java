package ru.naimix.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.naimix.model.CompaniesResponse;
import ru.naimix.model.CompanyRequest;
import ru.naimix.model.CompanyResponse;
import ru.naimix.service.CompanyService;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<CompaniesResponse> getList() {
        CompaniesResponse companyResponse = companyService.findAll();
        return new ResponseEntity<>(companyResponse, OK);
    }

    @PostMapping
    public ResponseEntity<CompanyResponse> create(@RequestBody CompanyRequest companyRequest) {
        CompanyResponse companyResponse = companyService.create(companyRequest);
        return new ResponseEntity<>(companyResponse, HttpStatus.CREATED);
    }

    @PatchMapping("/{companyId}")
    public ResponseEntity<CompanyResponse> update(@PathVariable Long companyId, @RequestBody CompanyRequest companyRequest) {
        CompanyResponse companyResponse = companyService.update(companyId, companyRequest);
        return new ResponseEntity<>(companyResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{companyId}")
    public ResponseEntity<Void> delete(@PathVariable Long companyId) {
        companyService.delete(companyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
