package com.aurochs.ourocks.service;


import com.aurochs.ourocks.exception.UserNotFoundException;
import com.aurochs.ourocks.model.Employee;
import com.aurochs.ourocks.model.Venue;
import com.aurochs.ourocks.repository.EmployeeRepository;
import com.aurochs.ourocks.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class VenueService {
    private final VenueRepository venueRepository;

    @Autowired
    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public Venue addVenue(Venue venue){
        return venueRepository.save(venue);
    }

    public List<Venue> findAllVenues(){
        return venueRepository.findAll();
    }

    public Venue updateVenue(Venue venue){
        return venueRepository.save(venue);
    }

    public void deleteVenue(Long venueId){
        venueRepository.deleteVenueByVenueId(venueId);
    }

    public Venue findVenueByVenueId(Long venueId){
        return venueRepository.findVenueByVenueId(venueId).orElseThrow(()-> new UserNotFoundException("Venue by id " + venueId + " was not found"));
    }
}
