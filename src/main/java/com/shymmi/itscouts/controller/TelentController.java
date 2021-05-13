package com.shymmi.itscouts.controller;

import com.shymmi.itscouts.Service.TalentService;
import com.shymmi.itscouts.model.Project;
import com.shymmi.itscouts.model.Talent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TelentController {

    private final TalentService talentService;

    public TelentController(TalentService talentService) {
        this.talentService = talentService;
    }

    @GetMapping("/talents")
    public List<Talent> findAll(){
        return talentService.findAll();
    }

    @GetMapping("/talents/{id}")
    public Talent findById(@PathVariable Long id){
        return talentService.findBytId(id);
    }

    @GetMapping("/talents/{id}/projects")
    public List<Project> getTalentProjects(@PathVariable Long id){
        return talentService.findTalentProjects(id);
    }

}
