package com.glenn.fruitbowl.services;

import java.util.List;

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
		// we need to check it exists?
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
	//----------------------------------------------------------------------------------------------
	//Custom @Query
	//Find by fruit type
	public List<Fruit> findByType(String type) {
		return this.repo.findByType(type);
	}
	//Custom @Query
	//Find by fruit colour
	public List<Fruit> findByColour(String colour){
		return this.repo.findByColour(colour);
	}
	//Custom @Query
	//Find by fruit price
	public List<Fruit> findByPrice(double price){
		return this.repo.findByPrice(price);
	}
	//Custom @Query
	//Find by type and colour
	public List<Fruit> findByTypeAndColour(String type, String colour){
		return this.repo.findByTypeAndColour(type, colour);
	}
	//Custom @Query
	//Find by type and price
	public List<Fruit> findByTypeAndPrice(String type, double price){
		return this.repo.findByTypeAndPrice(type, price);
	}
	//Custom @Query
	//Find by colour and price
	public List<Fruit> findByColourAndPrice(String colour, double price){
		return this.repo.findByColourAndPrice(colour, price);
	}
	//Custom @Query
	//Find all less than < price
	public List<Fruit> findLessThanPrice(double price){
		return this.repo.findLessThanPrice(price);		
	}
	//Custom @Query
	//Find all less than > price
	public List<Fruit> findGreaterThanPrice(double price){
		return this.repo.findGreaterThanPrice(price);
	}
	//Custom @Query
	//Find between prices x and y
	public List<Fruit> findGreaterThanButLessThanPrice(double price1, double price2){
		return this.repo.findGreaterThanButLessThanPrice(price1, price2);
	}
	//Custom @Query
	//Find by type and between prices
	public List<Fruit> findByTypeAndGreaterThanButLessThanPrice(String type, double price1, double price2){
		return this.repo.findByTypeAndGreaterThanButLessThanPrice(type, price1, price2);
	}
}
