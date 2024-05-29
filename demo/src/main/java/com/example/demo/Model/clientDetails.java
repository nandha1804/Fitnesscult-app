package com.example.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity

public class ClientDetails {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String clientName;
	    private String packageType;
	    private String joiningDate;
	    private String endingDate;
	    private String trainerName;
	   
	    
	    @ManyToOne
	    @JoinColumn(name = "trainer_id")
		@JsonIgnore
	    private TrainerDetails trainer;
	    
	    @OneToMany(mappedBy = "client")
	    @JsonIgnore
	    private List<TrainingProgress> trainingProgress;
	    
	    
		public ClientDetails() {
			super();
		}
	    
		public ClientDetails(Long id, String clientName,String packageType, String joiningDate, String endingDate, 
				TrainerDetails trainer,String trainerName) {
			super();
			this.id = id;
			this.clientName = clientName;
			this.packageType = packageType;
			this.joiningDate = joiningDate;
			this.endingDate = endingDate;
			this.trainer = trainer;
			this.trainerName = trainerName;
		}
		
		public String getTrainerName() {
			return trainerName;
		}

		public void setTrainerName(String trainerName) {
			this.trainerName = trainerName;
		}

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getClientName() {
			return clientName;
		}
		public void setClientName(String clientName) {
			this.clientName = clientName;
		}
		public String getJoiningDate() {
			return joiningDate;
		}
		public void setJoiningDate(String joiningDate) {
			this.joiningDate = joiningDate;
		}
		public String getEndingDate() {
			return endingDate;
		}
		public void setEndingDate(String endingDate) {
			this.endingDate = endingDate;
		}
		public TrainerDetails getTrainer() {
			return trainer;
		}
		public void setTrainer(TrainerDetails trainer) {
			this.trainer = trainer;
		}
		public String getPackageType() {
			return packageType;
		}

		public void setPackageType(String packageType) {
			this.packageType = packageType;
		}

}

	    
	    
