package com.aurochs.ourocks.repository;

import com.aurochs.ourocks.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface BeerRepository extends JpaRepository<Beer, Long> {
    void deleteBeerByBeerId(Long beerId);

    Optional<Beer> findBeerByBeerId(Long beerId);

    Beer findBeerByBeerName(String beerName);

}