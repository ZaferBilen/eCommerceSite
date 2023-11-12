package com.proje.eTicaretSitesi.business.abstracts;

import java.util.List;

import com.proje.eTicaretSitesi.entities.Product;

public interface IProductService {
	List<Product> getProducts();
	List<Product> getProductsByCategory();
	Product getProductById(long urunId);
}
