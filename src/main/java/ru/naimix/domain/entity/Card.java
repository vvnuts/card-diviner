package ru.naimix.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany(mappedBy = "cards",
            fetch = FetchType.LAZY)
    private List<Trump> trumps;
}
