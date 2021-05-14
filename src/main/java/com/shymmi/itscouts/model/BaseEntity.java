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
@MappedSuperclass
public class BaseEntity {

    @Id
    /*@GeneratedValue(strategy = GenerationType.AUTO)*/
    @Column(name = "id")
    private Long id;
}
