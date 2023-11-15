package com.proje.eTicaretSitesi.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proje.eTicaretSitesi.business.abstracts.IProductService;
import com.proje.eTicaretSitesi.business.requests.CreateProductRequest;
import com.proje.eTicaretSitesi.business.requests.UpdateProductRequest;
import com.proje.eTicaretSitesi.business.responses.GetAllProductsResponse;
import com.proje.eTicaretSitesi.business.responses.GetProductByIdResponse;
import com.proje.eTicaretSitesi.core.utilities.mappers.IModelMapperService;
import com.proje.eTicaretSitesi.dataAccess.IProductRepository;
import com.proje.eTicaretSitesi.entities.Product;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductManager implements IProductService{
	
	private IProductRepository productRepository;
	private IModelMapperService modelMapperService;
	
	
	@Override
	public List<GetAllProductsResponse> getAllProductsResponse() {
		List<Product> products = productRepository.findAll();
		
		List<GetAllProductsResponse> productsResponse = products.stream()
				.map(product ->this.modelMapperService.forResponse()
						.map(product, GetAllProductsResponse.class)).collect(Collectors.toList());
		
		return productsResponse;
	}
	/*@Override
	public List<Product> GetProductByCategoryResponse() {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	@Override
	public GetProductByIdResponse getById(long urunId) {
		Product product = this.productRepository.findById(urunId).orElseThrow();
		
		GetProductByIdResponse response = this.modelMapperService.forResponse().map(product,GetProductByIdResponse.class );
		return response;
	}
	@Override
	public void add(CreateProductRequest createProductRequest) {
		
		Product product = this.modelMapperService.forRequest()
				.map(createProductRequest, Product.class);
		this.productRepository.save(product);
		
	}
	@Override
	public void update(UpdateProductRequest updateProductRequest) {
		Product product = this.modelMapperService.forRequest()
				.map(updateProductRequest, Product.class);
		this.productRepository.save(product);
		
	}
	@Override
	public void delete(long id) {
		
		this.productRepository.deleteById(id);
		
	}

	
	
}
