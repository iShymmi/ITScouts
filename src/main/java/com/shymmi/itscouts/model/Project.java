package com.shymmi.itscouts.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Project extends BaseEntity {

    public Project(Long id, Talent talent, String title, String description) {
        super(id);
        this.talent = talent;
        this.title = title;
        this.description = description;
    }

    @ManyToOne
    private Talent talent;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    @Lob
    private String description;
}
