package com.glenn.fruitbowl.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.glenn.fruitbowl.persistence.domain.Fruit;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long>{

	// ?1 stands for 1st argument and ?2 the second argument and so on.........
	// What is nativeQuery true?
	/*	When defining a native query, you annotate your repository method with @Query, 
		set its nativeQuery attribute to true, and provide an SQL statement as the value.
		Spring Data's repository implementation then provides the required code to instantiate 
		a query for the statement provided in your @Query annotation.
	*/
	// Even though my table column is fruitType, h2 database has renamed it fruit_type
	
    // SELECT * from Person where name = '[name]';
//    List<Person> findPersonByName(String name); 

    // SELECT * from Person where name = '[name]' and age = [age];
//    List<Person> findPersonByNameAndAge(String name, int age); 

    // SELECT * from Person where name = '[name]' and age = [age] LIMIT 1;
//    Person findPersonByNameAndAge(String name, int age); 

    // SELECT * from Person where age > [age];
//    List<Person> findPersonByAgeGreaterThan(int age); 

    // SELECT * from Person where age < [age];
//    List<Person> findPersonByAgeLessThan(int age); 

    // SELECT * from Person where name = '[name]' IS NOT NULL;
//    List<Person> findPersonByNameIsNotNull(); 

    // SELECT * from Person where name = '[name]' IS NULL;
//    List<Person> findPersonByNameIsNull();
	
	
	
	
	
	// Find by Type
	@Query(value = "SELECT * FROM Fruit WHERE fruit_type =?1", nativeQuery = true)
	List<Fruit> findByType(String type);
	
	// Find by Colour
	@Query(value = "SELECT * FROM Fruit WHERE colour =?1", nativeQuery = true)
	List<Fruit> findByColour(String colour);
	
	// Find by Price
	@Query(value = "SELECT * FROM Fruit WHERE price =?1", nativeQuery = true)
	List<Fruit> findByPrice(Double price);
	
	// Find by type and colour
	@Query(value = "SELECT * FROM Fruit WHERE fruit_type =?1 and colour =?2", nativeQuery = true)
	List<Fruit> findByTypeAndColour(String type, String colour);
	
	// Find by type and price
	@Query(value = "SELECT * FROM Fruit WHERE fruit_type =?1 and price =2?", nativeQuery = true)
	List<Fruit> findByTypeAndPrice(String type, double price);
	
	// Find by colour and price
	@Query(value = "SELECT * FROM Fruit WHERE colour = 1? and price =2?", nativeQuery = true)
	List<Fruit> findByColourAndPrice(String colour, double price);
	
	// Find all less than < price
	@Query(value = "SELECT * FROM Fruit WHERE price < ?1", nativeQuery = true)
	List<Fruit> findLessThanPrice(double price);
	
	// Find all greater than > price
	@Query(value = "SELECT * FROM Fruit WHERE price > ?1", nativeQuery = true)
	List<Fruit> findGreaterThanPrice(double price);
		
	// Find between prices x and y
	@Query(value = "SELECT * FROM Fruit WHERE price > ?1 and < ?2", nativeQuery = true)
	List<Fruit> findGreaterThanButLessThanPrice(double price1, double price2);
	
	// Find between prices x and y
	
	
	
	// Find by type and between prices
	@Query(value = "SELECT * FROM fruit WHERE fruit_type = ?1 and price > ?2 and price < ?3", nativeQuery = true)
	List<Fruit> findByTypeAndGreaterThanButLessThanPrice(String type, double price1, double price2);
	
	
	
}
