package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.TrainerDetails;

@Repository
public interface TrainersRepository extends JpaRepository<TrainerDetails,Long> {

    
   
}
