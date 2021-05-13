package com.shymmi.itscouts.bootstrap;

import com.shymmi.itscouts.repository.TalentRepository;
import com.shymmi.itscouts.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final TalentRepository talentRepository;

    public DataLoader(TalentRepository talentDao) {
        this.talentRepository = talentDao;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        talentRepository.saveAll(loadTalents());
        log.debug("Loaded bootstrap data");
    }

    private List<Talent> loadTalents() {
        List<Talent> talents = new ArrayList<>();
        Talent talent = new Talent();
        Speciality speciality = new Speciality(1L, "DG", "asds");
        Technology technology = new Technology(1L, "DG","adsa");

        Project project = new Project("Extra project", "Some good rpoject");

        talent.setFirstName("Jan");
        talent.setLastName("Nowak");
        talent.setAbout("Some about text");

        talent.addProject(project);

        talents.add(talent);

        Project project1 = new Project("Another great project", "That really good");
        Talent talent1 = new Talent();
        talent1.setFirstName("Andrew");
        talent1.setLastName("Moki");
        talent1.setAbout("About him");

        talent1.addProject(project1);

        talents.add(talent1);

        return talents;
    }
}
