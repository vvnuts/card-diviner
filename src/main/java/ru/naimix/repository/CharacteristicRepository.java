package ru.naimix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.naimix.domain.entity.Characteristic;

public interface CharacteristicRepository extends JpaRepository<Characteristic, Long> {
}