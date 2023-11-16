package com.proje.eTicaretSitesi.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proje.eTicaretSitesi.entities.CartItem;

public interface ICartItemRepository extends JpaRepository<CartItem, Long> {
	
}
