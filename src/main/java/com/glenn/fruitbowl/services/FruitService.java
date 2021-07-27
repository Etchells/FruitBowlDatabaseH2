package com.glenn.fruitbowl.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.glenn.fruitbowl.persistence.domain.Fruit;
import com.glenn.fruitbowl.persistence.repository.FruitRepository;
@Service
public class FruitService {

	public FruitRepository repo;
	
	public FruitService(FruitRepository repo) {
		super();
		this.repo = repo;
	}
	//Read
	public List<Fruit> readAll(){
		return this.repo.findAll();
	}
	//Find by ID
	public Fruit findById(Long id) {
		return this.repo.findById(id).orElseThrow();
	}
	//Create
	public Fruit create(Fruit fruit) {
		return this.repo.saveAndFlush(fruit);
	}
	//Update
	public Fruit update(Long id,Fruit fruit) {
		// wee need to check it exists?
		Fruit exists = this.repo.getById(id);
		exists.setFruitType(fruit.getFruitType());
		exists.setColour(fruit.getColour());
		exists.setPrice(fruit.getPrice());
		Fruit updated = this.repo.save(exists);
		return updated;
	}
	//Delete
	public Boolean delete(Long id) {
		this.repo.deleteById(id); // this worked
		return this.repo.existsById(id); // this should be false
	}
}
