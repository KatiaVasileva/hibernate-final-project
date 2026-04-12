package com.javarush.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(schema = "world", name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 3)
    private String code;

    @Column(name = "code_2", nullable = false, length = 2)
    private String alternativeCode;

    @Column(nullable = false, length = 52)
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @JdbcTypeCode(Types.INTEGER)
    private Continent continent;

    @Column(nullable = false, length = 26)
    private String region;

    @Column(name = "surface_area", nullable = false, precision = 10, scale = 2)
    private BigDecimal surfaceArea;

    @Column(name = "indep_year")
    private Short independenceYear;

    @Column(nullable = false)
    private Integer population;

    @Column(name = "life_expectancy", precision = 3, scale = 1)
    private BigDecimal lifeExpectancy;

    @Column(precision = 10, scale = 2)
    private BigDecimal gnp;

    @Column(name = "gnpo_id", precision = 10, scale = 2)
    private BigDecimal gnpoId;

    @Column(name = "local_name", nullable = false, length = 45)
    private String localName;

    @Column(name = "government_form", nullable = false, length = 45)
    private String governmentForm;

    @Column(name = "head_of_state", length = 60)
    private String headOfState;

    @OneToOne
    @JoinColumn(name = "capital")
    private City city;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private Set<Language> languages;
}
