package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.TrainerDetails;
import com.example.demo.Service.TrainerService;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @PostMapping
    public ResponseEntity<TrainerDetails> createTrainer(@RequestBody TrainerDetails trainerDetails) {
        TrainerDetails savedTrainer = trainerService.saveTrainer(trainerDetails);
        return new ResponseEntity<>(savedTrainer, HttpStatus.CREATED);
    }
    
    
    @DeleteMapping("/{trainerId}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable long trainerId) {
        trainerService.deleteTrainer(trainerId);
        return ResponseEntity.noContent().build();
    }
    
    

    
}
