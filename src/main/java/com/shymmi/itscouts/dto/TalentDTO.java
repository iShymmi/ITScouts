package com.shymmi.itscouts.dto;

import com.shymmi.itscouts.model.Location;
import com.shymmi.itscouts.model.Speciality;
import com.shymmi.itscouts.model.Technology;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TalentDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private Location location;

    private Speciality speciality;

    private List<Technology> technologies = new ArrayList<>();
}
