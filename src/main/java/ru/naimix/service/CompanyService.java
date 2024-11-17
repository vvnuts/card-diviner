package ru.naimix.service;

import ru.naimix.domain.entity.Company;
import ru.naimix.model.CompaniesResponse;
import ru.naimix.model.CompanyRequest;
import ru.naimix.model.CompanyResponse;

public interface CompanyService {
    CompaniesResponse findAll();

    CompanyResponse create(CompanyRequest companyRequest);

    CompanyResponse update(Long companyId, CompanyRequest companyRequest);

    void delete(Long companyId);

    Company getCompanyForCharacteristic(Long companyId);
}
