package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.TrainingProgress;
import com.example.demo.Service.TrainingProgressService;

@RestController
public class TrainingProgressController {
     
	
	@Autowired
	private TrainingProgressService trainingprogressservice;
	
	
	@PostMapping("/saveProgress")
    public ResponseEntity<String> saveProgress(@RequestBody TrainingProgress trainingProgress) {
        return trainingprogressservice.saveProgress(trainingProgress);
	}
	
	@GetMapping("/client/{clientId}")
    public ResponseEntity<List<TrainingProgress>> getProgressByClientId(@PathVariable Long clientId) {
        List<TrainingProgress> progressList = trainingprogressservice.getProgressByClientId(clientId);
        return ResponseEntity.ok(progressList);
    }
	
}
