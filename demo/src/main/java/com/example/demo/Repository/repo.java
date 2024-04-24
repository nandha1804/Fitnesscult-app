package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Details;

@Repository
public interface repo extends JpaRepository<Details,Integer> {

    
    List<Details> findByName(String name);
    List<Details> findByid(int id);
}
