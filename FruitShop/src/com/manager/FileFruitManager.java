package com.manager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dto.Fruit;
import com.dto.Receipt;
import com.utils.Constants;

public class FileFruitManager {


	public static void main(String[] args) {
		System.out.println(readFileFruit(Constants.MARKET_FILE));
		System.out.println(readFileFruit(Constants.PURCHASE_FILE));
	}

	public static List<Fruit> readFileFruit(String route) {
		List<Fruit> listReturn = new ArrayList<Fruit>();
		try {
			 List<String> lines = Files.readAllLines(Paths.get(route));
			 lines = lines.stream().skip(1).collect(Collectors.toList());
			 lines.stream().forEach(f->{
				 List<String> listAux = Stream.of(f.split(","))
							.collect(Collectors.toList());
				 Fruit fruit = new Fruit();
				 if(route.equals(Constants.MARKET_FILE)){
					 fruit.setName(listAux.get(0));
					 fruit.setPrice(Double.valueOf(listAux.get(1).trim()));
				 }
				 else{
					 fruit.setName(listAux.get(0));
					 fruit.setQuantity(Integer.valueOf(listAux.get(1).trim()));
				 }
				 listReturn.add(fruit);
			 });
			
		} catch (IOException e) {
			System.out.println("Error---" + e.toString());
		}
		
		return listReturn;
	}
	
	public static void writeReceipt(Receipt rec) throws IOException{
		Files.write(Paths.get("./"+Constants.RECEIPT_FILE), rec.toString().getBytes());
	}



}
