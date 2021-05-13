package com.shymmi.itscouts.repository;

import com.shymmi.itscouts.model.Project;
import com.shymmi.itscouts.model.Talent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TalentRepository extends JpaRepository<Talent, Long> {

    @Override
    @Query("SELECT DISTINCT t FROM Talent t " +
            "LEFT JOIN FETCH t.projects " +
            "LEFT JOIN FETCH t.speciality " +
            "LEFT JOIN FETCH t.technologies")
    List<Talent> findAll();

    @Override
    @Query("SELECT DISTINCT t FROM Talent t " +
            "LEFT JOIN FETCH t.projects " +
            "LEFT JOIN FETCH t.speciality " +
            "LEFT JOIN FETCH t.technologies " +
            "WHERE t.id = ?1")
    Optional<Talent> findById(Long id);

    @Query("SELECT p FROM Project p " +
            "LEFT JOIN FETCH p.talent " +
            "WHERE p.talent.id = ?1")
    List<Project> findAllProjectsByTalentId(Long id);
}
