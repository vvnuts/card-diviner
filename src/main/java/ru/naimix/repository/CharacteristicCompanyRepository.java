package ru.naimix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naimix.domain.entity.CharacteristicCompany;

public interface CharacteristicCompanyRepository extends JpaRepository<CharacteristicCompany, Long> {
}