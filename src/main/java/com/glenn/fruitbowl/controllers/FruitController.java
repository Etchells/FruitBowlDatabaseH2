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
	//--------------------------------------------------------------------------------------------
	//Using my custom @Query
	//Find by fruit type
	@GetMapping("/findbytype/{type}")
	public ResponseEntity<List<Fruit>> findByType (@PathVariable String type){
		return new ResponseEntity<List<Fruit>>(this.service.findByType(type),HttpStatus.OK);
	}
	//Using my custom @Query
	//Find by fruit colour
	@GetMapping("/findbycolour/{colour}")
	public ResponseEntity<List<Fruit>> findByColour (@PathVariable String colour){
		return new ResponseEntity<List<Fruit>>(this.service.findByColour(colour),HttpStatus.OK);
	}
	//Using my custom @Query
	//Find by fruit price
	@GetMapping("/findbyprice/{price}")
	public ResponseEntity<List<Fruit>> findByPrice (@PathVariable double price){
		return new ResponseEntity<List<Fruit>>(this.service.findByPrice(price),HttpStatus.OK);
	}
	//Using my custom @Query
	//Find by type and colour
	@GetMapping("/findbytypeandcolour/{type}/{colour}")
	public ResponseEntity<List<Fruit>> findByTypeAndColour (@PathVariable String type, String colour){
		return new ResponseEntity<List<Fruit>>(this.service.findByTypeAndColour(type, colour),HttpStatus.OK);
	}
	//Using my custom @Query
	//Find by type and price
	@GetMapping("/findbytypeandprice/{type}/{price}")
	public ResponseEntity<List<Fruit>> findByTypeAndPrice (@PathVariable String type, double price){
		return new ResponseEntity<List<Fruit>>(this.service.findByTypeAndPrice(type, price),HttpStatus.OK);
	}
	//Using my custom @Query
	//Find by colour and price
	@GetMapping("/findbycolourandprice/{colour}/{price}")
	public ResponseEntity<List<Fruit>> findByColourAndPrice (@PathVariable String colour, double price){
		return new ResponseEntity<List<Fruit>>(this.service.findByColourAndPrice(colour, price),HttpStatus.OK);
	}
	//Using my custom @Query
	//Find all less than < price
	@GetMapping("/findlessthanprice/{price}")
	public ResponseEntity<List<Fruit>> findLessThanPrice (@PathVariable double price){
		return new ResponseEntity<List<Fruit>>(this.service.findLessThanPrice(price),HttpStatus.OK);
	}
	//Using my custom @Query
	//Find all less than > price
	@GetMapping("/findgreaterthanprice/{price}")
	public ResponseEntity<List<Fruit>> findGreaterThanPrice (@PathVariable double price){
		return new ResponseEntity<List<Fruit>>(this.service.findGreaterThanPrice(price),HttpStatus.OK);
	}
	//Using my custom @Query
	//Find between prices x and y
	@GetMapping("/frindgreaterthanbutlessthanprice/{price1}/{price2}")
	public ResponseEntity<List<Fruit>> findGreaterThanButLessThanPrice (@PathVariable double price1, double price2){
		return new ResponseEntity<List<Fruit>>(this.service.findGreaterThanButLessThanPrice(price1, price2),HttpStatus.OK);
	}
	//Using my custom @Query
	//Find by type and between prices
	@GetMapping("findbytypeandgreaterthanbutlessthanprice/{type}/{price1}/{price2}")
	public ResponseEntity<List<Fruit>> findByTypeAndGreaterThanButLessThanPrice (@PathVariable String type, double price1, double price2){
		return new ResponseEntity<List<Fruit>>(this.service.findByTypeAndGreaterThanButLessThanPrice(type, price1, price2),HttpStatus.OK);
	}
}
