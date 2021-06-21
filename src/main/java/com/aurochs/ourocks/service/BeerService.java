package com.aurochs.ourocks.service;

import com.aurochs.ourocks.exception.BeerNotFoundException;
import com.aurochs.ourocks.exception.UserNotFoundException;
import com.aurochs.ourocks.model.Beer;
import com.aurochs.ourocks.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BeerService {
    private  final BeerRepository beerRepository;

    @Autowired
    public BeerService(BeerRepository beerRepository){
        this.beerRepository = beerRepository;
    }

    public Beer addBeer(Beer beer){
        return beerRepository.save(beer);
    }

    public List<Beer> findAllBeers(){
        return beerRepository.findAll();
    }

    public Beer updateBeer(Beer beer){
        return beerRepository.save(beer);
    }

    public Beer findBeerById(Long beerId){
        return beerRepository.findBeerByBeerId(beerId).orElseThrow(() -> new BeerNotFoundException("Beer by id " + beerId + " was not found"));
    }

    public void deleteBeer(Long beerId){
        beerRepository.deleteBeerByBeerId(beerId);
    }

}
