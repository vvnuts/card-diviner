package ru.naimix.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Card {
    @Id
    Long id;
    @Column(length = 500)
    String name;
    @JsonProperty("meaning_up")
    @Column(columnDefinition = "TEXT")
    String meaningUp;
    @JsonProperty("meaning_rev")
    @Column(columnDefinition = "TEXT")
    String meaningRev;
    @JsonProperty("desc")
    @Column(columnDefinition = "TEXT")
    String description;
}
