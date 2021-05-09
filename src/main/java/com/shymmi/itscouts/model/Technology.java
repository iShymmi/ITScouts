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
public class Technology extends BaseEntity {

    public Technology(Long id, String name, String desription) {
        super(id);
        this.name = name;
        this.desription = desription;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String desription;
}
