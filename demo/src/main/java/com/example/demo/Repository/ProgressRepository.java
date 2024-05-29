package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.Model.TrainingProgress;

@Repository
public interface ProgressRepository extends JpaRepository<TrainingProgress,Long>{

	  List<TrainingProgress> findByClientId(Long clientId);
}
