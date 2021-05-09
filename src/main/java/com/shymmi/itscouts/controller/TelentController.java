package com.shymmi.itscouts.controller;

import com.shymmi.itscouts.exception.TalentNotFoundException;
import com.shymmi.itscouts.repository.TalentRepository;
import com.shymmi.itscouts.model.Talent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TelentController {

    private final TalentRepository talentDao;

    public TelentController(TalentRepository talentDao) {
        this.talentDao = talentDao;
    }

    @GetMapping("/talents")
    List<Talent> findAll(){
        return talentDao.findAll();
    }

    @GetMapping("/talents/{id}")
    Talent findById(@PathVariable Long id){

        return talentDao.findById(id)
                .orElseThrow(() -> new TalentNotFoundException(id));
    }


}
