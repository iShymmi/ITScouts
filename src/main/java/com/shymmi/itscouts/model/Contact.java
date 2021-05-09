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
public class Contact extends BaseEntity {

    public Contact(Long id, String location, String phoneNumber, String email) {
        super(id);
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Column(name = "location")
    private String location;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

}
