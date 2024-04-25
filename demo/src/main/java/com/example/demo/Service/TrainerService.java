package com.example.demo.Service;

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
}

