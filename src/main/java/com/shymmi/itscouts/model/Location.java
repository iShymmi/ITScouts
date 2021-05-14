package com.shymmi.itscouts.model;

import lombok.Builder;
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

    @Builder
    public Location(Long id, String name, String zipCode) {
        super(id);
        this.name = name;
        this.zipCode = zipCode;
    }

    @Column(name = "location")
    private String name;

    @Column(name = "zip_code")
    private String zipCode;

}
