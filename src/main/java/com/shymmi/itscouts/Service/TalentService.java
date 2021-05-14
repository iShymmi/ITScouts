package com.shymmi.itscouts.Service;

import com.shymmi.itscouts.dto.TalentDTO;
import com.shymmi.itscouts.exception.TalentNotFoundException;
import com.shymmi.itscouts.model.Project;
import com.shymmi.itscouts.model.Talent;
import com.shymmi.itscouts.repository.TalentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TalentService {

    private final TalentRepository talentRepository;
    ModelMapper modelMapper;

    public TalentService(TalentRepository talentRepository) {
        this.talentRepository = talentRepository;
        modelMapper = new ModelMapper();
    }

    public List<TalentDTO> findAll(){
        List<Talent> talents = talentRepository.findAll();

        List<TalentDTO> talentsDTO = new ArrayList<>();

        talents.forEach(talent -> talentsDTO.add(modelMapper.map(talent, TalentDTO.class)));

        return talentsDTO;
    }

    public Talent findBytId(Long id) {
        return talentRepository.findById(id)
                .orElseThrow(() -> new TalentNotFoundException(id));
    }

    public Talent addNewTalent(Talent talent){
        return talentRepository.save(talent);
    }

    public void deleteById(Long id){
        talentRepository.deleteById(id);
    }

    public List<Project> findTalentProjects(Long id){
        return talentRepository.findAllProjectsByTalentId(id);
    }
}
