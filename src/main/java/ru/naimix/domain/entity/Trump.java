package ru.naimix.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Trump {
    @Id
    Long id;
    LocalDateTime date;
    int score;
    @ManyToOne
    @JoinColumn(name = "employee_to_id", nullable = false)
    private User userTo;
    @ManyToOne
    @JoinColumn(name = "employee_from_id")
    private User userFrom;
    @ManyToOne
    @JoinColumn(name = "company_from_id")
    private Company companyFrom;
}
