package com.ct.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ct.productmanagement.entity.Product;
import com.ct.productmanagement.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService service;
/*
	{
		"productId":576,
		"productName":"apple",
		"productPrice":19000,
		"productQuantity":20,
		"productDesc":"laptop"
		}
*/
	@PostMapping("/insertProduct") // http://localhost:1111/product/insertProduct -->JSON
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}

	@PutMapping("/updateProduct") // http://localhost:1111/product/updateProduct -->JSON
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}

	@DeleteMapping("/deleteProduct/{pid}") // http://localhost:1111/product/deleteProduct/123 -->JSON
	public Product deleteProduct(@PathVariable("pid") int productId) {
		return service.deleteProduct(productId);
	}

	@GetMapping("/getProduct/{pid}") // http://localhost:1111/product/getProduct/123 -->JSON
	public Product fetchProduct(@PathVariable("pid") int productId) {
		return service.getProduct(productId);
	}

	@GetMapping("/getProducts") // http://localhost:1111/product/getProducts -->JSON
	public List<Product> fetchAllProducts() {
		return service.getAllProducts();
	}

	@GetMapping("/getProducts/{minPrice}/{maxPrice}") // http://localhost:1111/product/getProducts/10000/40000 -->JSON
	public List<Product> fetchAllProducts(@PathVariable("minPrice") int minPrice, @PathVariable("maxPrice") int maxPrice) {
		return service.getAllProductsInBetween(minPrice, maxPrice);
	}

	@GetMapping("/getProducts/{pname}") // http://localhost:1111/product/getProducts/samsung -->JSON
	public List<Product> fetchAllProducts(@PathVariable("pname") String productName) {
		return service.getAllProductsByName(productName);
	}
}// postman
