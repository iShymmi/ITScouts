package com.shymmi.itscouts.Service;

import com.shymmi.itscouts.exception.TalentNotFoundException;
import com.shymmi.itscouts.model.Project;
import com.shymmi.itscouts.model.Talent;
import com.shymmi.itscouts.repository.TalentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentService {

    private final TalentRepository talentRepository;

    public TalentService(TalentRepository talentRepository) {
        this.talentRepository = talentRepository;
    }

    public List<Talent> findAll(){
        return talentRepository.findAll();
    }

    public Talent findBytId(Long id) {
        return talentRepository.findById(id)
                .orElseThrow(() -> new TalentNotFoundException(id));
    }

    public List<Project> findTalentProjects(Long id){
        return talentRepository.findAllProjectsByTalentId(id);
    }
}
