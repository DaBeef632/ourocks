package com.aurochs.ourocks.controller;

import com.aurochs.ourocks.model.Beer;
import com.aurochs.ourocks.model.Rock;
import com.aurochs.ourocks.service.BeerService;
import com.aurochs.ourocks.service.RockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rocks")
public class RockController {

    private final RockService rockService;

    public RockController(RockService rockService) {
        this.rockService = rockService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Rock>> getAllRock(){
        List<Rock> rocks = rockService.findAllRocks();
        return new ResponseEntity<>(rocks, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Rock> getBeerById(@PathVariable("rockId") Long rockId){
        Rock rock = rockService.findRockById(rockId);
        return new ResponseEntity<>(rock, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Rock> addRock(@RequestBody Rock rock){
        Rock newRock = rockService.addRock(rock);
        return new ResponseEntity<>(newRock, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Rock> updateBeer(@RequestBody Rock rock){
        Rock updateRock = rockService.updateRock(rock);
        return new ResponseEntity<>(updateRock, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rock> deleteRock(@PathVariable("rockId") Long rockId){
        rockService.deleteRock(rockId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
