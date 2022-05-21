package com.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fruit implements Serializable {

	private long id;
	private String name;
	private int quantity;
	private double price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Fruit [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}

	public Fruit(long id, String name, int quantity, double price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public Fruit() {
		super();
		// TODO Auto-generated constructor stub
	}

}
