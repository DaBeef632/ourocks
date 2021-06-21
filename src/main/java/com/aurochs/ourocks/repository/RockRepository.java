package com.aurochs.ourocks.repository;

import com.aurochs.ourocks.model.Beer;
import com.aurochs.ourocks.model.Rock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RockRepository extends JpaRepository<Rock, Long> {
    void deleteRockByRockId(Long rockId);

    Optional<Rock> findRockByRockId(Long rockId);
}
