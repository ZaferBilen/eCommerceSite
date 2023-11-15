package com.proje.eTicaretSitesi.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proje.eTicaretSitesi.business.abstracts.ICategoryService;
import com.proje.eTicaretSitesi.business.requests.CreateCategoryRequest;
import com.proje.eTicaretSitesi.business.requests.UpdateCategoryRequest;
import com.proje.eTicaretSitesi.business.responses.GetAllCategoryResponse;
import com.proje.eTicaretSitesi.business.responses.GetCategoryByIdResponse;
import com.proje.eTicaretSitesi.core.utilities.mappers.IModelMapperService;
import com.proje.eTicaretSitesi.dataAccess.ICategoryRepository;
import com.proje.eTicaretSitesi.entities.Category;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryManager implements ICategoryService{

	private ICategoryRepository categoryRepository;
	private IModelMapperService modelMapperService;
	
	@Override
	public List<GetAllCategoryResponse> GetAllCategoryResponse() {
		
		List<Category> categories = categoryRepository.findAll();
		
		List<GetAllCategoryResponse> categoryResponse= categories.stream()
				.map(category ->this.modelMapperService.forResponse()
						.map(category, GetAllCategoryResponse.class)).collect(Collectors.toList());
		
		return categoryResponse;
	}

	@Override
	public GetCategoryByIdResponse getById(long urunId) {
	
		Category category = this.categoryRepository.findById(urunId).orElseThrow();
		
		GetCategoryByIdResponse response = this.modelMapperService.forResponse().map(category, GetCategoryByIdResponse.class);
		return response;
	}

	@Override
	public void add(CreateCategoryRequest createCategoryRequest) {
		
		Category category=this.modelMapperService.forRequest()
				.map(createCategoryRequest, Category.class);
		this.categoryRepository.save(category);
		
	}

	@Override
	public void update(UpdateCategoryRequest updateCategoryRequest) {

		Category category=this.modelMapperService.forRequest()
				.map(updateCategoryRequest, Category.class);
		this.categoryRepository.save(category);
		
	}

	@Override
	public void delete(long id) {
		
		this.categoryRepository.deleteById(id);
		
	}

}
