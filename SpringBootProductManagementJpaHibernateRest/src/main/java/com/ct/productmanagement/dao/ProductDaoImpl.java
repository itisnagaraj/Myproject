package com.ct.productmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ct.productmanagement.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Product addProduct(Product product) {
		entityManager.persist(product);
		return entityManager.find(Product.class, product.getProductId());
	}

	@Override
	public Product updateProduct(Product product) {

		return entityManager.merge(product);
	}

	@Override
	public Product deleteProduct(int productId) {
		Product product = entityManager.find(Product.class, productId);
		entityManager.remove(product);
		return product;
	}

	@Override
	public Product getProduct(int productId) {

		return entityManager.find(Product.class, productId);
	}

	@Override
	public List<Product> getAllProducts() {

		return entityManager.createQuery("select e from Product e").getResultList();
	}

	@Override
	public List<Product> getAllProductsInBetween(int minPrice, int maxPrice) {
		Query query = entityManager.createQuery("select e from Product e where e.productPrice between ?1 and ?2");
		query.setParameter(1, minPrice);
		query.setParameter(2, maxPrice);

		return query.getResultList();
	}

	@Override
	public List<Product> getAllProductsByName(String productName) {
		Query query = entityManager.createQuery("select e from Product e where e.productName=?1");
		query.setParameter(1, productName);

		return query.getResultList();

	}

}
