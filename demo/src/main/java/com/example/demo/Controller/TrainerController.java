package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.TrainerDetails;
import com.example.demo.Service.TrainerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    
    @GetMapping
    public ResponseEntity<List<TrainerDetails>> getAllTrainers() {
        List<TrainerDetails> trainers = trainerService.getAllTrainers();
        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }

    @GetMapping("/{trainerId}")
    public ResponseEntity<TrainerDetails> getTrainerById(@PathVariable Long trainerId) {
        TrainerDetails trainer = trainerService.getTrainerById(trainerId);
        if (trainer != null) {
            return new ResponseEntity<>(trainer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{trainerId}")
    public ResponseEntity<TrainerDetails> updateTrainer(@PathVariable Long trainerId, @RequestBody TrainerDetails trainerDetails) {
        TrainerDetails updatedTrainer = trainerService.updateTrainer(trainerId, trainerDetails);
        if (updatedTrainer != null) {
            return new ResponseEntity<>(updatedTrainer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
}
