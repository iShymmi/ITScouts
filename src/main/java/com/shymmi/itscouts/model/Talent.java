package com.shymmi.itscouts.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Talent extends Person{

    @Builder
    public Talent(Long id, String firstName, String lastName, String phoneNumber,
                  String email, Location location, Speciality speciality, List<Technology> technologies,
                  String about, Set<Project> projects) {
        super(id, firstName, lastName, phoneNumber, email);
        this.location = location;
        this.speciality = speciality;
        this.technologies = technologies;
        this.about = about;
        this.projects = projects;
    }

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    @ManyToMany
    @JoinTable(
            name = "Talent_Technology",
            joinColumns = { @JoinColumn(name = "talent_id")},
            inverseJoinColumns = { @JoinColumn(name = "technology_id")}
    )
    private List<Technology> technologies = new ArrayList<>();

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
