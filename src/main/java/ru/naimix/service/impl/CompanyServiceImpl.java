package ru.naimix.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.naimix.domain.entity.Company;
import ru.naimix.mapper.CompanyMapper;
import ru.naimix.model.CompaniesResponse;
import ru.naimix.model.CompanyRequest;
import ru.naimix.model.CompanyResponse;
import ru.naimix.repository.CompanyRepository;
import ru.naimix.service.CompanyService;
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;
    @Override
    @Transactional(readOnly = true)
    public CompaniesResponse findAll() {
        var companies = companyRepository.findAll();
        var companiesResponse = companyMapper.toCompanyResponseList(companies);
        var companiesFromGenerated = new CompaniesResponse();
        companiesFromGenerated.content(companiesResponse);
        return companiesFromGenerated;
    }

    @Override
    @Transactional
    public CompanyResponse create(CompanyRequest companyRequest) {
        var companyFromRequest = companyMapper.toCompany(companyRequest);
        var saveAndFlush = companyRepository.saveAndFlush(companyFromRequest);
        return companyMapper.toCompanyResponse(saveAndFlush);
    }

    @Override
    public CompanyResponse update(Long companyId, CompanyRequest companyRequest) {
        var company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Компания не найдена!"));
        var updateCompany = companyMapper.updateCompany(company, companyRequest);
        var saveAndFlush = companyRepository.saveAndFlush(updateCompany);
        return companyMapper.toCompanyResponse(saveAndFlush);
    }

    @Override
    public void delete(Long companyId) {
        companyRepository.deleteById(companyId);
    }

    @Override
    public Company findCompanyById(Long companyId) {
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Компания не найдена в БД"));
    }
}
