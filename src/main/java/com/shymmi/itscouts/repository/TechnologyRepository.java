package com.shymmi.itscouts.repository;

import com.shymmi.itscouts.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}
