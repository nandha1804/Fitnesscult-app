package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.ClientDetails;
import com.example.demo.Service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientDetails> createClient(@RequestBody ClientDetails clientDetails, @RequestParam Long trainerId) {
        // Call the service method to save the client with the specified trainer
        ClientDetails savedClient = clientService.saveClientWithTrainer(clientDetails, trainerId);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }
    
   
    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable long clientId) {
        clientService.deleteClient(clientId);
        return ResponseEntity.noContent().build();
    }
}
