package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ClientDetails;

@Repository
public interface ClientRepository extends JpaRepository<ClientDetails,Long> {

    
    
}
