package com.shymmi.itscouts.controller;

import com.shymmi.itscouts.Service.TalentService;
import com.shymmi.itscouts.dto.TalentDTO;
import com.shymmi.itscouts.model.Project;
import com.shymmi.itscouts.model.Talent;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TelentController {

    private final TalentService talentService;

    public TelentController(TalentService talentService) {
        this.talentService = talentService;
    }

    @GetMapping("/talents")
    public List<TalentDTO> findAll(){
        return talentService.findAll();
    }

    @GetMapping("/talents/{id}")
    public Talent findById(@PathVariable Long id){
        return talentService.findBytId(id);
    }

    @DeleteMapping("/talents/{id}")
    public void deleteById(@PathVariable Long id){
        talentService.deleteById(id);
    }

    @PostMapping("/talents")
    public Talent addNewTalent(@RequestBody Talent talent){
        return talentService.addNewTalent(talent);
    }

    @GetMapping("/talents/{id}/projects")
    public List<Project> getTalentProjects(@PathVariable Long id){
        return talentService.findTalentProjects(id);
    }

}
