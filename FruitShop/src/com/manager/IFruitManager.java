package com.manager;

import java.util.List;

import com.dto.Fruit;

public interface IFruitManager {

	public List<Fruit> listFruits(List<Fruit> listMarket, List<Fruit> listPurchase);

}
