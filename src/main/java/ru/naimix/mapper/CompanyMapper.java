package ru.naimix.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.naimix.domain.entity.Company;
import ru.naimix.model.CompanyRequest;
import ru.naimix.model.CompanyResponse;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {
    CompanyResponse toCompanyResponse(Company company);
    List<CompanyResponse> toCompanyResponseList(List<Company> companies);
    Company toCompany(CompanyRequest companyRequest);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Company updateCompany(@MappingTarget Company company, CompanyRequest companyRequest);
}
