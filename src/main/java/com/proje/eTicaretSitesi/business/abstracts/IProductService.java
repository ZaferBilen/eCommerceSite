package com.proje.eTicaretSitesi.business.abstracts;

import java.util.List;

import com.proje.eTicaretSitesi.business.requests.CreateProductRequest;
import com.proje.eTicaretSitesi.business.requests.UpdateProductRequest;
import com.proje.eTicaretSitesi.business.responses.GetAllProductsResponse;
import com.proje.eTicaretSitesi.business.responses.GetProductByIdResponse;

public interface IProductService {
	List<GetAllProductsResponse> getAllProductsResponse();
	//List<Product> GetProductByCategoryResponse();
	GetProductByIdResponse getById(long urunId);
	void add(CreateProductRequest createProductRequest);
	void update(UpdateProductRequest createProductRequest);
	void delete(long id);
}
