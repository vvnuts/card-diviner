package ru.naimix.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Compatibility {
    @Id
    Long id;
    @Min(0)
    @Max(100)
    int compatibility;
    @ManyToOne(fetch = FetchType.LAZY)
    Characteristic characteristic;
    @ManyToOne(fetch = FetchType.LAZY)
    Trump trump;
}
