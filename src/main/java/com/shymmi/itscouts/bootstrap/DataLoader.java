package com.shymmi.itscouts.bootstrap;

import com.shymmi.itscouts.model.Location;
import com.shymmi.itscouts.model.Speciality;
import com.shymmi.itscouts.model.Talent;
import com.shymmi.itscouts.model.Technology;
import com.shymmi.itscouts.repository.LocationRepository;
import com.shymmi.itscouts.repository.SpecialityRepository;
import com.shymmi.itscouts.repository.TalentRepository;
import com.shymmi.itscouts.repository.TechnologyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final TalentRepository talentRepository;
    private final SpecialityRepository specialityRepository;
    private final TechnologyRepository technologyRepository;
    private final LocationRepository locationRepository;

    public DataLoader(TalentRepository talentRepository, SpecialityRepository specialityRepository,
                      TechnologyRepository technologyRepository, LocationRepository locationRepository) {
        this.talentRepository = talentRepository;
        this.specialityRepository = specialityRepository;
        this.technologyRepository = technologyRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadData();
        log.debug("Loaded bootstrap data");
    }

    private void loadData() {
        List<Talent> talents = new ArrayList<>();
        List<Technology> technologies = new ArrayList<>();
        List<Speciality> specialities = new ArrayList<>();
        List<Location> locations = new ArrayList<>();

        locations.add(Location.builder().id(1L).name("Gdansk").zipCode("80-130").build());

        locationRepository.saveAll(locations);

        technologies.add(Technology.builder().id(1L).name("Angular").build());
        technologies.add(Technology.builder().id(2L).name("Java").build());
        technologies.add(Technology.builder().id(3L).name("Spring").build());
        technologies.add(Technology.builder().id(4L).name("Type Script").build());
        technologies.add(Technology.builder().id(5L).name("Java Script").build());

        technologyRepository.saveAll(technologies);

        specialities.add(Speciality.builder().id(1L).name("Front-end Developer").build());
        specialities.add(Speciality.builder().id(2L).name("Back-end Developer").build());
        specialities.add(Speciality.builder().id(3L).name("Full-stack Developer").build());
        specialities.add(Speciality.builder().id(4L).name("Project Manager").build());
        specialities.add(Speciality.builder().id(5L).name("Quality Assurance Engineer").build());

        specialityRepository.saveAll(specialities);

        talents.add(Talent.builder().id(1L).firstName("Jan").lastName("Nowak")
                    .about("Hi I'm Janek Nowak").email("janek@nowak.com").phoneNumber("600300400")
                    .speciality(specialities.get(0))
                    .technologies(Collections.singletonList(technologies.get(0)))
                    .build());

        talents.add(Talent.builder().id(2L).firstName("Adam").lastName("Mak")
                .about("Hi I'm Adam Mak").email("adam@mak.com").phoneNumber("954984658")
                .speciality(specialities.get(1))
                .technologies(Collections.singletonList(technologies.get(1)))
                .build());

        talents.add(Talent.builder().id(3L).firstName("Tadeusz").lastName("Wus")
                .about("Hi I'm Tadeusz Wus").email("tadeusz@wus.com").phoneNumber("546844648")
                .speciality(specialities.get(2))
                .technologies(Collections.singletonList(technologies.get(2)))
                .build());

        talents.add(Talent.builder().id(4L).firstName("Andrew").lastName("Malikowski")
                .about("Hi I'm Andre Malikowski").email("andrew@malikowski.com").phoneNumber("65498454651")
                .speciality(specialities.get(2))
                .technologies(Collections.singletonList(technologies.get(3)))
                .location(locations.get(0))
                .build());

        List<Technology> techs = new ArrayList<>();

        techs.add(technologies.get(0));
        techs.add(technologies.get(1));

        talents.add(Talent.builder().id(5L).firstName("Wiktor").lastName("Wallerman")
                .about("Hi I'm Wiktor Wallerman").email("wiktor@wallerman.com").phoneNumber("4865485485")
                .speciality(specialities.get(4))
                .technologies(techs)
                .location(locations.get(0))
                .build());


        talentRepository.saveAll(talents);
    }
}
