package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.demo.Exceptions.TrainerNotFoundException;
import com.example.demo.Model.ClientDetails;
import com.example.demo.Model.TrainerDetails;
import com.example.demo.Repository.ClientRepository;
import com.example.demo.Repository.TrainersRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private TrainersRepository trainerRepository;

    public ClientDetails saveClientWithTrainer(ClientDetails clientDetails, Long trainerId) {
        // Here you can fetch the TrainerDetails entity corresponding to the given trainerId
        // and set it in the clientDetails entity before saving
        // For simplicity, I assume you already have a method to fetch TrainerDetails by ID
        TrainerDetails trainer = fetchTrainerById(trainerId);
        if (trainer == null) {
            throw new TrainerNotFoundException("Trainer not found with ID: " + trainerId);
        }
        if (trainer != null) {
            // Set trainer name in client details
            clientDetails.setTrainerName(trainer.getTrainerName());
        }
        clientDetails.setTrainer(trainer);
        return clientRepository.save(clientDetails);
    }

    // Method to fetch TrainerDetails by ID
    public TrainerDetails fetchTrainerById(Long trainerId) {
        Optional<TrainerDetails> trainerOptional = trainerRepository.findById(trainerId);
        return trainerOptional.orElse(null); // Return the trainer if found, otherwise return null
    }
    

    public void deleteClient(long clientId) {
        clientRepository.deleteById(clientId);
    }

}
