package com.shymmi.itscouts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project extends BaseEntity {

    @ManyToOne
    private Talent talent;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    @Lob
    private String description;
}
