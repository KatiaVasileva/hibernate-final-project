package com.javarush.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.sql.Types;

@Getter
@Setter
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

    @Column(name = "is_official")
    @JdbcTypeCode(Types.BIT)
    private Boolean isOfficial;

    @Column(nullable = false, precision = 4, scale = 1)
    private BigDecimal percentage;
}
