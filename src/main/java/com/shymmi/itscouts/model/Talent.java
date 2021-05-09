package com.shymmi.itscouts.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Data
public class Talent extends Person{

    public Talent(Long id, String firstName, String lastName, Contact contact, Set<Speciality> speciality, Set<Technology> technologies, String about, Set<Project> projects) {
        super(id, firstName, lastName);
        this.contact = contact;
        this.speciality = speciality;
        this.technologies = technologies;
        this.about = about;
        this.projects = projects;
    }

    @OneToOne(cascade = CascadeType.ALL)
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
