package com.aurochs.ourocks.repository;

import com.aurochs.ourocks.model.Employee;
import com.aurochs.ourocks.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    void deleteVenueByVenueId(Long venueId);

    Optional<Venue> findVenueByVenueId(Long venueId);
}
