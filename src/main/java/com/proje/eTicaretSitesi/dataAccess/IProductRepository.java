package com.proje.eTicaretSitesi.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proje.eTicaretSitesi.entities.Category;
import com.proje.eTicaretSitesi.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByCategory(Category category);
}
