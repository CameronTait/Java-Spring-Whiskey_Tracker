package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;



    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> findDistilleriesThatHaveRegionsNamedQueryString(
            @RequestParam(name ="region") String region){
        if (region != null) {
            return new ResponseEntity<>(distilleryRepository.findByRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }

//    @GetMapping(value = "/distilleries/region")
//    public ResponseEntity<List<Distillery>> findDistilleriesThatHaveRegion(@PathVariable String region){
//        return new ResponseEntity<>(distilleryRepository.findByRegion(region), HttpStatus.OK);
//    }




}
