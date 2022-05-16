package com.example.demothymeleaf.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "country")
    private String country;

    @Column(name = "last_update")
    private java.sql.Timestamp lastUpdate;

}

