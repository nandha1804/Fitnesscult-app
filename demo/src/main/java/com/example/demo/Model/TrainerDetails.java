package com.example.demo.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TrainerDetails {

	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String trainerName;
	    private String session;
	    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
	    private List<ClientDetails> clients;
	    
		public TrainerDetails(Long id, String trainerName, String session, List<ClientDetails> clients) {
			super();
			this.id = id;
			this.trainerName = trainerName;
			this.session = session;
			this.clients = clients;
		}

		public TrainerDetails() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTrainerName() {
			return trainerName;
		}

		public void setTrainerName(String trainerName) {
			this.trainerName = trainerName;
		}

		public String getSession() {
			return session;
		}

		public void setSession(String session) {
			this.session = session;
		}

		public List<ClientDetails> getClients() {
			return clients;
		}

		public void setClients(List<ClientDetails> clients) {
			this.clients = clients;
		}
		
		
	    
	    
}
