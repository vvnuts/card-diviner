package ru.naimix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naimix.domain.entity.Characteristic;
import ru.naimix.domain.entity.CharacteristicCompany;
import ru.naimix.domain.entity.Company;

import java.util.List;

public interface CharacteristicCompanyRepository extends JpaRepository<CharacteristicCompany, Long> {
    CharacteristicCompany findByCharacteristicAndCompany(Characteristic characteristic, Company company);

    List<CharacteristicCompany> findAllByCompany(Company company);
}