package com.ct.productmanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.productmanagement.dao.ProductDao;
import com.ct.productmanagement.entity.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao dao;

	@Override
	public Product addProduct(Product product) {
		return dao.addProduct(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return dao.updateProduct(product);
	}

	@Override
	public Product deleteProduct(int productId) {

		return dao.deleteProduct(productId);
	}

	@Override
	public Product getProduct(int productId) {

		return dao.getProduct(productId);
	}

	@Override
	public List<Product> getAllProducts() {

		return dao.getAllProducts();
	}

	@Override
	public List<Product> getAllProductsInBetween(int minPrice, int maxPrice) {

		return dao.getAllProductsInBetween(minPrice, maxPrice);
	}

	@Override
	public List<Product> getAllProductsByName(String productName) {

		return dao.getAllProductsByName(productName);
	}

}
