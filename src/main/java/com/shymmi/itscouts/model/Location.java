package com.shymmi.itscouts.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Location extends BaseEntity {

    @Column(name = "location")
    private String name;

    @Column(name = "zip_code")
    private String zipCode;

}
