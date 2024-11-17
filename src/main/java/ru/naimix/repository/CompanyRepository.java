package ru.naimix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naimix.domain.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}