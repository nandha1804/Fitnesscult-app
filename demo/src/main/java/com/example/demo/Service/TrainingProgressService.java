package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.TrainingProgress;
import com.example.demo.Repository.ProgressRepository;

@Service
public class TrainingProgressService {
     
	@Autowired
	private ProgressRepository progressrepository;
	
	
	public ResponseEntity<String> saveProgress(TrainingProgress trainingProgress) {
        Long clientId = trainingProgress.getClient().getId();
        List<TrainingProgress> existingProgressList = progressrepository.findByClientId(clientId);

        if (!existingProgressList.isEmpty()) {
            TrainingProgress latestProgress = existingProgressList.get(existingProgressList.size() - 1);
            trainingProgress.setPreviousWeight(latestProgress.getPreviousWeight());
            trainingProgress.setProgress(trainingProgress.getPreviousWeight() - latestProgress.getPreviousWeight());
        } else {
            trainingProgress.setPreviousWeight(0);
            trainingProgress.setProgress(0);
        }

        progressrepository.save(trainingProgress);
        return new ResponseEntity<>("Added Successfully", HttpStatus.OK);
    }



	public List<TrainingProgress> getProgressByClientId(Long clientId) {
        return progressrepository.findByClientId(clientId);
    }
}
