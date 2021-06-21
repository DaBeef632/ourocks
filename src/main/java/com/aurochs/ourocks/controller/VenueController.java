package com.aurochs.ourocks.controller;

import com.aurochs.ourocks.model.Rock;
import com.aurochs.ourocks.model.Venue;
import com.aurochs.ourocks.service.RockService;
import com.aurochs.ourocks.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venue")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Venue>> getAllVenues(){
        List<Venue> venues = venueService.findAllVenues();
        return new ResponseEntity<>(venues, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Venue> getVenueByVenueId(@PathVariable("venueId") Long venueId){
        Venue venue = venueService.findVenueByVenueId(venueId);
        return new ResponseEntity<>(venue, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Venue> addVenue(@RequestBody Venue venue){
        Venue newVenue = venueService.addVenue(venue);
        return new ResponseEntity<>(newVenue, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Venue> updateVenue(@RequestBody Venue venue){
        Venue updateVenue = venueService.updateVenue(venue);
        return new ResponseEntity<>(updateVenue, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Venue> deleteVenue(@PathVariable("venueId") Long venueId){
        venueService.deleteVenue(venueId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
