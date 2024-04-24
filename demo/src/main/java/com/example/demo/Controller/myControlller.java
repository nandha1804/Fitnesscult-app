package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Details;
import com.example.demo.Repository.repo;
import com.example.demo.Service.myService;

@RestController
@RequestMapping("/fitnesscult")
public class myControlller {
	
	@Autowired
	private myService service;
	
	
	
	@Autowired
	private repo drepo;
	
	
	@PostMapping("/signup")
	public String savedetails(@RequestBody Details details) {
		service.savedetails(details);
		return "Ok";
		
	}
	
	@GetMapping("/list")
	public List<Details> getAllDetails() {
        return service.getAllDetails();
    }
	
	@GetMapping("/{name}")
	public List<Details> getbyName(@PathVariable("name") String name){
		return service.name(name);
	}
	
	@GetMapping("/id/{id}")
	public List<Details> getByid(@PathVariable("id") int id){
		return service.getid(id);
	}
	
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") int id, @RequestBody Details updateDetails) {
	      service.updateById(id, updateDetails);
	      return "Details updated successfully for ID: " + id;
	    }
	@DeleteMapping("/{id}")
	public String Deleteid(@PathVariable("id")int id) { 
	     service.DeleteById(id);
	     return "Deleted " + id;
	}
}

	


