package com.aurochs.ourocks.controller;

import com.aurochs.ourocks.model.Beer;
import com.aurochs.ourocks.model.Employee;
import com.aurochs.ourocks.service.BeerService;
import com.aurochs.ourocks.service.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Beer>> getAllBeer(){
        List<Beer> beers = beerService.findAllBeers();
        return new ResponseEntity<>(beers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Beer> getBeerById(@PathVariable("beerId") Long beerId){
        Beer beer = beerService.findBeerById(beerId);
        return new ResponseEntity<>(beer, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Beer> addBeer(@RequestBody Beer beer){
        Beer newBeer = beerService.addBeer(beer);
        return new ResponseEntity<>(newBeer, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Beer> updateBeer(@RequestBody Beer beer){
        Beer updateBeer = beerService.updateBeer(beer);
        return new ResponseEntity<>(updateBeer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Beer> deleteBeer(@PathVariable("beerId") Long beerId){
        beerService.deleteBeer(beerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
