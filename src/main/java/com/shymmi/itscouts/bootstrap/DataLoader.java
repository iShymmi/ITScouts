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

    private final TalentRepository talentDao;

    public DataLoader(TalentRepository talentDao) {
        this.talentDao = talentDao;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        talentDao.saveAll(loadTalents());
        log.debug("Loaded bootstrap data");
    }

    private List<Talent> loadTalents() {
        List<Talent> talents = new ArrayList<>();
        Talent talent = new Talent();
        Contact contact = new Contact(1l,"Gd","23","32");
        Speciality speciality = new Speciality(1l, "DG", "asds");
        Technology technology = new Technology(1l, "DG","adsa");

        String about = "Some about text";

        Project project = new Project(1l, talent, "sadsa","sadsad");

        //talent.setContact(contact);

        talent.setFirstName("Jan");
        talent.setLastName("Nowak");
        talent.setAbout("About text");

        talents.add(talent);

        return talents;
    }
}
