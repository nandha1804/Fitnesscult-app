package com.example.demo.Controller;

import java.util.List;

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

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDetails> updateClient(@PathVariable long clientId, @RequestBody ClientDetails updatedClient) {
        ClientDetails client = clientService.updateClient(clientId, updatedClient);
        return ResponseEntity.ok(client);
    }

      @GetMapping
      public List<ClientDetails> getAllClients() {
          return clientService.getAllClients();
      }

      
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDetails> getClientById(@PathVariable Long clientId) {
        ClientDetails trainer = clientService.getClientById(clientId);
        if (trainer != null) {
            return new ResponseEntity<>(trainer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
