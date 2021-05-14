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
public class Technology extends BaseEntity {

    @Builder
    public Technology(Long id, String name) {
        super(id);
        this.name = name;
    }

    @Column(name = "name")
    private String name;
}
