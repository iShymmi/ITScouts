package com.shymmi.itscouts.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Talent extends Person{

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "contact")
    private Contact contact;

    @OneToMany
    @JoinColumn(name = "speciality_id", nullable = true)
    private Set<Speciality> speciality;

    @OneToMany
    @JoinColumn(name = "technology_id")
    private Set<Technology> technologies;

    @Lob
    @Column(name = "about")
    private String about;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "talent")
    private Set<Project> projects;
}
