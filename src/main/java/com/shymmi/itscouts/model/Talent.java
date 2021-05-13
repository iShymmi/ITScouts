package com.shymmi.itscouts.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Talent extends Person{

    @OneToOne(cascade = CascadeType.ALL)
    private Location contact;

    @OneToMany
    @JoinColumn(name = "speciality_id", nullable = true)
    private Set<Speciality> speciality;

    @OneToMany
    @JoinColumn(name = "technology_id")
    private Set<Technology> technologies;

    @Lob
    @Column(name = "about")
    private String about;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "talent")
    private Set<Project> projects = new HashSet<>();

    public Talent addProject(Project project) {
        project.setTalent(this);
        this.projects.add(project);

        return this;
    }
}
