package ru.naimix.domain.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Min(0)
    @Max(100)
    int compatibility;
    @ManyToOne(fetch = FetchType.LAZY)
    Characteristic characteristic;
    @ManyToOne(fetch = FetchType.LAZY)
    Trump trump;
}
