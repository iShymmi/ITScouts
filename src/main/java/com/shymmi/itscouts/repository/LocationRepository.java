package com.shymmi.itscouts.repository;

import com.shymmi.itscouts.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
