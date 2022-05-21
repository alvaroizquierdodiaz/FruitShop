package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.dto.Fruit;
import com.dto.Receipt;
import com.manager.FileFruitManager;
import com.manager.FruitManager;
import com.utils.Constants;

/**
 * Launcher of the app FruitShop.
 * We see a menu with the options.
 * 
 * @author FSGil
 *
 */
public class Menu {
	
	static FruitManager fruitManager = new FruitManager();
	static FileFruitManager fileFruits = new FileFruitManager();

	public static void main(String[] args) {

		try {
			while (true) {
				showMenu();
				managerFruit(chooseOption());
				System.out.println();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void showMenu() {
		System.out.println("1. Generate receipt from files");
		System.out.println("0. Bye!");
		System.out.print("Welcome to the FruitShop. Select your option: ");
	}

	public static int chooseOption() throws IOException {
		BufferedReader con = new BufferedReader(new InputStreamReader(
				System.in));
		int a = 0;
		try{
			a = Integer.parseInt(con.readLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Not a valid option. Choose a number.");
			a=99;
		}
		return a;
	}

	public static void managerFruit(int option) throws IOException{
		switch (option) {
		case 1:
			/*
			 * Reading market file...
			 */
			System.out.println("Reading the market file...");
			List<Fruit> marketList = fileFruits.readFileFruit(Constants.MARKET_FILE);
			System.out.println(fileFruits.readFileFruit(Constants.MARKET_FILE));
	
			/*
			 * Reading purchase file...
			 */
			System.out.println("Reading the purchase file...");
			List<Fruit> purchaseList = fileFruits.readFileFruit(Constants.PURCHASE_FILE);
			System.out.println(fileFruits.readFileFruit(Constants.PURCHASE_FILE));
			
			/*
			 * Union lists
			 */
			List<Fruit> fruits = fruitManager.listFruits(marketList, purchaseList);
			System.out.println(fruits);
			
			/*
			 * Generate Receipt
			 */
			Receipt rec = fruitManager.generateReceipt(fruits);
			System.out.println(rec);
			
			/*
			 * Generate receipt file
			 */
			fileFruits.writeReceipt(rec);
			
			break;
		default:
			System.out.println("Please, choose a valid option...");
			break;
		}
	}
}
