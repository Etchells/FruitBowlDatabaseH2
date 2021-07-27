package com.glenn.fruitbowl.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glenn.fruitbowl.persistence.domain.Fruit;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long>{

}
