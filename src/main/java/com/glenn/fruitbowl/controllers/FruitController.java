package com.glenn.fruitbowl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.glenn.fruitbowl.persistence.domain.Fruit;
import com.glenn.fruitbowl.services.FruitService;

@RestController
public class FruitController {

	@Autowired
	private FruitService service;
	
	@GetMapping("/readfromdb")
	// List because we would like to return multiple records
	public ResponseEntity<List<Fruit>> getAll(){
		return new ResponseEntity<List<Fruit>>(this.service.readAll(),HttpStatus.OK);
	}
	
	@GetMapping("/findbyid/{id}")
	// ID is unique
	// We only return 1
	public ResponseEntity<Fruit> findById (@PathVariable("id")Long id){
		return new ResponseEntity<Fruit>(this.service.findById(id),HttpStatus.FOUND);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Fruit> create (@RequestBody Fruit fruit){
		return new ResponseEntity<Fruit>(this.service.create(fruit),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Fruit> update (@PathVariable("id")Long id, @RequestBody Fruit fruit){
		return new ResponseEntity<Fruit>(this.service.update(id, fruit),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete (@PathVariable("id")Long id){
		return new ResponseEntity<Boolean>(this.service.delete(id),HttpStatus.NO_CONTENT);
	}
	
}
