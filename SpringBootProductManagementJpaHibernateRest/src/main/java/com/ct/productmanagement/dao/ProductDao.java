package com.ct.productmanagement.dao;

import java.util.List;

import com.ct.productmanagement.entity.Product;

public interface ProductDao {
	public Product addProduct(Product product);

	public Product updateProduct(Product product);

	public Product deleteProduct(int productId);

	public Product getProduct(int productId);

	public List<Product> getAllProducts();
	public List<Product> getAllProductsInBetween(int minPrice, int maxPrice);

	public List<Product> getAllProductsByName(String productName);
}
