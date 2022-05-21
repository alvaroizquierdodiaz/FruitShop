package com.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Receipt implements Serializable {

	private List<Fruit> fruit = new ArrayList<Fruit>();
	private List<Offer> offers = new ArrayList<Offer>();
	private double price;

	public List<Fruit> getFruit() {
		return fruit;
	}

	public void setFruit(List<Fruit> fruit) {
		this.fruit = fruit;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Receipt [fruit=" + fruit + ", offers=" + offers + ", price=" + price + "]";
	}

}
