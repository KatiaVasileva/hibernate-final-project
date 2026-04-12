package com.javarush.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(schema = "world", name = "country_language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(nullable = false, length = 30)
    private String language;

    @Column(name = "is_official", nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isOfficial = false;

    @Column(nullable = false, precision = 4, scale = 1)
    private BigDecimal percentage;
}
