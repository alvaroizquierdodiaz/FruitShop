package com.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dto.Fruit;
import com.dto.Offer;
import com.dto.Receipt;

/**
 * 
 * Manager Fruits
 * 
 * @author FSGil
 *
 */
public class FruitManager implements IFruitManager {

	public List<Fruit> listFruits(List<Fruit> listMarket, List<Fruit> listPurchase) {

		List<Fruit> fruits = new ArrayList<Fruit>();

		// Union both lists
		for (Iterator<Fruit> iterator = listMarket.iterator(); iterator.hasNext();) {
			Fruit fruitM = (Fruit) iterator.next();
			for (Iterator<Fruit> iterator2 = listPurchase.iterator(); iterator2.hasNext();) {
				Fruit fruitP = (Fruit) iterator2.next();
				if (fruitM.getName().equals(fruitP.getName())) {
					fruitM.setQuantity(fruitP.getQuantity());
					fruits.add(fruitM);
				}
			}
		}
		return fruits;
	}

	public Receipt generateReceipt(List<Fruit> listFruit) {
		Receipt rec = new Receipt();
		List<Fruit> listFruitAux = listFruit;

		for (Iterator<Fruit> iterator = listFruitAux.iterator(); iterator.hasNext();) {
			Fruit fruit = (Fruit) iterator.next();
			String str = fruit.getName();
			switch (str) {
			case "Pear":
				System.out.println("Pear");
				int numberOffer2 = fruit.getQuantity()/2;
				for (int i = 0; i < numberOffer2; i++) {
					rec.getOffers().add(new Offer(2, "Get a free Orange for every 2 Pears you buy."));
				}
				for (int i = 0; i < listFruitAux.size(); i++) {
					if(listFruitAux.get(i).equals("Orange")){
						listFruitAux.get(i).setQuantity(listFruitAux.get(i).getQuantity()+numberOffer2);
					}
				}
				double priceAux2 = rec.getPrice();
				int numberOffer3 = ((int)(fruit.getPrice()*fruit.getQuantity()))/4;
				for (int i = 0; i < numberOffer3; i++) {
					rec.getOffers().add(new Offer(3, "For every 4 € spent on Pears, we will deduct one euro from your final invoice."));
				}
				priceAux2 = priceAux2 + (fruit.getPrice()*fruit.getQuantity()) - numberOffer3; 
				rec.setPrice(priceAux2);
				
				
				break;
			case "Orange":
				System.out.println("Orange");
				double priceAux = rec.getPrice();
				priceAux = priceAux + (fruit.getPrice()*fruit.getQuantity()); 
				rec.setPrice(priceAux);
				break;
			case "Apple":
				System.out.println("Apple");
				int numberOffer1 = fruit.getQuantity()/3;
				for (int i = 0; i < numberOffer1; i++) {
					rec.getOffers().add(new Offer(1, "Buy 3 Apples and pay 2."));
				}
				double priceAux3 = rec.getPrice();
				priceAux3 = priceAux3 + (fruit.getPrice()*fruit.getQuantity()) - fruit.getPrice()*numberOffer1; 
				rec.setPrice(priceAux3);
				break;
			default:
				break;
			}
		}
		
		rec.setFruit(listFruitAux);
		return rec;
	}
}
