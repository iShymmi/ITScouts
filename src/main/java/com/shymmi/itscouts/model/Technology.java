package com.shymmi.itscouts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Technology extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String desription;
}
