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

import com.proje.eTicaretSitesi.business.abstracts.ICategoryService;
import com.proje.eTicaretSitesi.business.requests.CreateCategoryRequest;
import com.proje.eTicaretSitesi.business.requests.UpdateCategoryRequest;
import com.proje.eTicaretSitesi.business.responses.GetAllCategoryResponse;
import com.proje.eTicaretSitesi.business.responses.GetCategoryByIdResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categories")  
@AllArgsConstructor
public class CategoryController {
	
	private ICategoryService categoryService;
	
	@GetMapping
	public List<GetAllCategoryResponse> getAllCategoryResponse(){
		
		return categoryService.GetAllCategoryResponse();
	}
	
	@GetMapping ("/{id}")
	public GetCategoryByIdResponse getById(long id){
		
		return categoryService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateCategoryRequest createCategoryRequest) {
		
		this.categoryService.add(createCategoryRequest);
	}
	
	@PutMapping
	public void update(@RequestBody() @Valid()UpdateCategoryRequest createCategoryRequest) {
		
		this.categoryService.update(createCategoryRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		
		this.categoryService.delete(id);
	
	}
	
	
	
	

}
