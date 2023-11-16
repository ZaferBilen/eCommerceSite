package com.proje.eTicaretSitesi.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proje.eTicaretSitesi.business.abstracts.IProductService;
import com.proje.eTicaretSitesi.business.requests.CreateProductRequest;
import com.proje.eTicaretSitesi.business.requests.UpdateProductRequest;
import com.proje.eTicaretSitesi.business.responses.GetAllProductsResponse;
import com.proje.eTicaretSitesi.business.responses.GetProductByIdResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")  
@AllArgsConstructor
public class ProductsController {
	
	private IProductService productService;
	
	@GetMapping("/getall")
	public List<GetAllProductsResponse> getAllProductsResponse() {
		return productService.getAllProductsResponse();
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateProductRequest createProductRequest) {
		
		this.productService.add(createProductRequest);
	}
	
	@GetMapping("/{id}")
	public GetProductByIdResponse getById(long urunId) {
		
		return productService.getById(urunId);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody() @Valid() UpdateProductRequest updateProductRequest) {
		
		this.productService.update(updateProductRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@PathVariable long id) {
		
		this.productService.delete(id);
	}
	

}
