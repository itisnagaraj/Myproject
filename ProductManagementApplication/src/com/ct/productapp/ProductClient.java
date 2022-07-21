package com.ct.productapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ProductClient {
	public static void main(String[] args) throws ParseException {
		int productId;
		String productName;
		int productPrice;
		int productQuantity;
		Date manufacturingDate;
		String date;
		Product product;
		HashMap<Integer, Product> products = new HashMap<Integer, Product>();//get,put,remove,keyset,entryset
		while (true) {
			System.out.println("Product Managemant Application");
			System.out.println("1.Add Product");
			System.out.println("2.Update Product");
			System.out.println("3.Delete Product");
			System.out.println("4.Get Product By Id");
			System.out.println("5.Get All Products");
			System.out.println("6.Get All Products ByName");
			System.out.println("7.Get All Products InBetween Prices");
			System.out.println("8.Get All products InOrder");
			System.out.println("9.Exit");

			Scanner scanner = new Scanner(System.in);

			int option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.println("Add Product");
				System.out.println("Enter ProductId :");
				productId = scanner.nextInt();
				System.out.println("Enter ProductName :");
				productName = scanner.next();
				System.out.println("Enter ProductPrice :");
				productPrice = scanner.nextInt();
				System.out.println("Enter ProductQuantity :");
				productQuantity = scanner.nextInt();
				System.out.println("Enter ManufacturingDate  dd/MM/yyyy:");
				date = scanner.next();
				manufacturingDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
				product = new Product(productId, productName, productPrice, productQuantity, manufacturingDate);
				products.put(productId, product);
				System.out.println("Product Added Successfully " + productId);
				break;
			case 2:
				System.out.println("Update Product");
				System.out.println("Enter Old ProductId :");
				productId = scanner.nextInt();
				System.out.println("Enter ProductName :");
				productName = scanner.next();
				System.out.println("Enter ProductPrice :");
				productPrice = scanner.nextInt();
				System.out.println("Enter ProductQuantity :");
				productQuantity = scanner.nextInt();
				System.out.println("Enter ManufacturingDate  dd/MM/yyyy:");
				date = scanner.next();
				manufacturingDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
				Product product1 = new Product(productId, productName, productPrice, productQuantity,
						manufacturingDate);
				products.put(productId, product1);
				System.out.println("Product Updated Successfully " + productId);

				break;
			case 3:
				System.out.println("Delete Product");
				System.out.println("Enter  ProductId :");
				productId = scanner.nextInt();
				products.remove(productId);
				System.out.println("Product Deleted Successfully " + productId);
				break;

			case 4:
				System.out.println("Get Product");
				System.out.println("Enter  ProductId :");
				productId = scanner.nextInt();
				product = products.get(productId);
				System.out.println(product);
				break;
			case 5:
				System.out.println("Get All  Products");
				Set<Integer> keys = products.keySet();
				for (int key : keys) {
					System.out.println(products.get(key));
				}
				break;
			case 6:
				System.out.println("Get All  Products By Name");
				System.out.println("Enter ProductName :");
				productName = scanner.next();
				Set<Integer> keys1 = products.keySet();
				for (int key : keys1) {
					Product productByName = products.get(key);
					if (productName.equals(productByName.getProductName()))
						System.out.println(productByName);
				}
				break;
			case 7:
				System.out.println("Enter ProductMinPrice :");// 10000 
				int minProductPrice = scanner.nextInt();
				System.out.println("Enter ProductMaxPrice :");//15000
				int maxProductPrice = scanner.nextInt();
				Set<Integer> keys2 = products.keySet();
				for (int key : keys2) {
					Product productByPrices = products.get(key);

					int price = productByPrices.getProductPrice();
					if (minProductPrice <= price && maxProductPrice >= price) {
						System.out.println(productByPrices);
					}
				}
				break;
			case 8:
				TreeMap<Integer, Product> orderedProducts = new TreeMap<Integer, Product>();
				Set<Entry<Integer, Product>> sets = products.entrySet();
				Iterator<Entry<Integer, Product>> itr = sets.iterator();
				while (itr.hasNext()) {
					Entry<Integer, Product> entry = itr.next();
					orderedProducts.put(entry.getKey(), entry.getValue());
				}
				Set<Integer> orderedKeys = orderedProducts.keySet();
				for (Integer key : orderedKeys) {
					System.out.println(orderedProducts.get(key));
				}
				break;

			default:

				scanner.close();
				System.out.println("**************Thank You*************");
				System.exit(0);
				
				break;
			}
		}
	}
}
