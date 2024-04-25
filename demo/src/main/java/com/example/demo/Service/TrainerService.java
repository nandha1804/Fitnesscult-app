package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.TrainerDetails;
import com.example.demo.Repository.TrainersRepository;

@Service
public class TrainerService {

    @Autowired
    private TrainersRepository trainersRepository;

    public TrainerDetails saveTrainer(TrainerDetails trainerDetails) {
        return trainersRepository.save(trainerDetails);
    }

    public String deleteTrainer(long trainerId) {
    	trainersRepository.deleteById(trainerId);
    	return "Deleted "+ trainerId + "Successfully";
    }
    public List<TrainerDetails> getAllTrainers() {
        return trainersRepository.findAll();
    }

    public TrainerDetails getTrainerById(Long trainerId) {
        Optional<TrainerDetails> optionalTrainer = trainersRepository.findById(trainerId);
        return optionalTrainer.orElse(null);
    }

    public TrainerDetails updateTrainer(Long trainerId, TrainerDetails trainerDetails) {
        Optional<TrainerDetails> optionalTrainer = trainersRepository.findById(trainerId);
        if (optionalTrainer.isPresent()) {
            TrainerDetails existingTrainer = optionalTrainer.get();
            // Update existing trainer with new details
            existingTrainer.setTrainerName(trainerDetails.getTrainerName());
            existingTrainer.setSession(trainerDetails.getSession());
        
            // Save and return updated trainer
            return trainersRepository.save(existingTrainer);
        } else {
            // Trainer with the given ID not found
            return null;
        }
    }

 }
   


