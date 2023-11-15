package com.proje.eTicaretSitesi.business.abstracts;

import java.util.List;

import com.proje.eTicaretSitesi.business.requests.CreateCategoryRequest;
import com.proje.eTicaretSitesi.business.requests.UpdateCategoryRequest;
import com.proje.eTicaretSitesi.business.responses.GetAllCategoryResponse;
import com.proje.eTicaretSitesi.business.responses.GetCategoryByIdResponse;

public interface ICategoryService {
	
	List<GetAllCategoryResponse> GetAllCategoryResponse();
	GetCategoryByIdResponse getById(long urunId);
	void add(CreateCategoryRequest createCategoryRequest);
	void update(UpdateCategoryRequest createCategoryRequest);
	void delete(long id);
}
