package com.proje.eTicaretSitesi.business.abstracts;

import com.proje.eTicaretSitesi.business.requests.CreateCartItemRequest;

public interface ICartItemService {

	 void add(CreateCartItemRequest createCartItemRequest );  
	 void delete(Long id);
}
