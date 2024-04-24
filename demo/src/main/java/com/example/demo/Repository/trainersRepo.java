package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Trainers;

@Repository
public interface trainersRepo extends JpaRepository<Trainers,Integer> {

    
    List<Trainers> findByName(String name);
    List<Trainers> findByid(int id);
}
