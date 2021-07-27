package com.glenn.fruitbowl.persistence.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fruit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fruitType;
	
	private String colour;

	private double price;

	public Fruit() {
		super();
	}

	public Fruit(String fruitType, String colour, double price) {
		super();
		this.fruitType = fruitType;
		this.colour = colour;
		this.price = price;
	}

	public Fruit(Long id, String fruitType, String colour, double price) {
		super();
		this.id = id;
		this.fruitType = fruitType;
		this.colour = colour;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFruitType() {
		return fruitType;
	}

	public void setFruitType(String fruitType) {
		this.fruitType = fruitType;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Fruit [id=" + id + ", fruitType=" + fruitType + ", colour=" + colour + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(colour, fruitType, id, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruit other = (Fruit) obj;
		return Objects.equals(colour, other.colour) && Objects.equals(fruitType, other.fruitType)
				&& Objects.equals(id, other.id)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	
}
