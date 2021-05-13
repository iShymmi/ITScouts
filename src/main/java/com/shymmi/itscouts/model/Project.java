package com.shymmi.itscouts.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
@Data
@EqualsAndHashCode(exclude = {"talent"}, callSuper = false)
@NoArgsConstructor
public class Project extends BaseEntity {

    public Project(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @JsonBackReference
    @ManyToOne
    private Talent talent;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    @Lob
    private String description;
}
