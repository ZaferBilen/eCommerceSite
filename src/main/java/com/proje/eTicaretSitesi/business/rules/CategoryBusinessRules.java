package com.proje.eTicaretSitesi.business.rules;

import org.springframework.stereotype.Service;

import com.proje.eTicaretSitesi.core.utilities.exceptions.BusinessException;
import com.proje.eTicaretSitesi.dataAccess.ICategoryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryBusinessRules {
	
	private ICategoryRepository categoryRepository;
	
	public void checkIfCategoryNameExists(String name) {
		if(this.categoryRepository.existsByName(name)) {
			throw new BusinessException("Category name already exists");
		}
	}
}
