package com.proje.eTicaretSitesi.business.concretes;

import org.springframework.stereotype.Service;

import com.proje.eTicaretSitesi.business.abstracts.ICartItemService;
import com.proje.eTicaretSitesi.business.requests.CreateCartItemRequest;
import com.proje.eTicaretSitesi.core.utilities.mappers.IModelMapperService;
import com.proje.eTicaretSitesi.dataAccess.ICartItemRepository;
import com.proje.eTicaretSitesi.entities.CartItem;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartItemManager implements ICartItemService {

	private ICartItemRepository cartItemRepository;
	private IModelMapperService modelMapperService;
 
    
	@Override
	public void add(CreateCartItemRequest createCartItemRequest ) {
		
		CartItem cartItem = this.modelMapperService.forRequest()
				.map(createCartItemRequest, CartItem.class);
				this.cartItemRepository.save(cartItem);
	}

	@Override
	public void delete(Long id) {
		
		this.cartItemRepository.deleteById(id);
	}

}
