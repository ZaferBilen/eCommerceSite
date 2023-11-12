package com.proje.eTicaretSitesi.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proje.eTicaretSitesi.entities.Cart;
import com.proje.eTicaretSitesi.entities.CartItem;

public interface ICartProductRepository extends JpaRepository<CartItem, Long> {
	List<CartItem> findByBasket(Cart cart);
}
