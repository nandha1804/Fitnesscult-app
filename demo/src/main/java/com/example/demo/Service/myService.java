package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Details;
import com.example.demo.Repository.repo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class myService {
	
	@Autowired
	private repo drepo;
	
	
	public void savedetails(Details details) {
		String name  = details.getName();
		String doj = details.getDoj();
		String package_type = details.getPackage_type();
		drepo.save(details);
	}
	
	public List<Details> getAllDetails() {
        return drepo.findAll();
    }
	 
	public List<Details> name(String name){
		return drepo.findByName(name);
	}
	
	public List<Details> getid(int id){
		return drepo.findByid(id);
	}
	
	public void DeleteById(int id) {
		 drepo.deleteById(id);
	}
	
	 public void updateById(int id, Details updateDetails) {
	        
	        Details existingDetails = drepo.findById(id).orElse(null);
	        if (existingDetails == null) {
	            throw new EntityNotFoundException("Details with ID " + id + " not found");
	        }
	        existingDetails.setName(updateDetails.getName());
	        drepo.save(existingDetails); 
	        
	        
	    }


	public String login(String name,String password){
		if(!)
		
		
		
		return "Login success";
	}
	 
	 
}
