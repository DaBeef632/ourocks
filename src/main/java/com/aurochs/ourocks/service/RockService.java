package com.aurochs.ourocks.service;

import com.aurochs.ourocks.exception.RockNotFoundException;
import com.aurochs.ourocks.model.Rock;
import com.aurochs.ourocks.repository.RockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RockService {
    private  final RockRepository rockRepository;

    @Autowired
    public RockService(RockRepository rockRepository){
        this.rockRepository = rockRepository;
    }

    public Rock addRock(Rock rock){
        return rockRepository.save(rock);
    }

    public List<Rock> findAllRocks(){
        return rockRepository.findAll();
    }

    public Rock updateRock(Rock rock){
        return rockRepository.save(rock);
    }

    public Rock findRockById(Long rockId){
        return rockRepository.findRockByRockId(rockId).orElseThrow(() -> new RockNotFoundException("Rock by id " + rockId + " was not found"));
    }

    public void deleteRock(Long rockId){
        rockRepository.deleteRockByRockId(rockId);
    }
}
