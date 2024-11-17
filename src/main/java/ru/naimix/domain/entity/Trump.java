package ru.naimix.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Trump {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "card_trump",
            joinColumns = @JoinColumn(name = "trump_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"))
    private List<Card> cards;
}
