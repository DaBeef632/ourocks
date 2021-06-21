package com.aurochs.ourocks.repository;

import com.aurochs.ourocks.model.Beer;
import com.aurochs.ourocks.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RepositoryRestResource
public interface BeerRepository extends JpaRepository<Beer, Long> {
    void deleteBeerByBeerId(Long beerId);

    Optional<Beer> findBeerByBeerId(Long beerId);
}
