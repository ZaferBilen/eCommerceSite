package com.proje.eTicaretSitesi.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proje.eTicaretSitesi.entities.Basket;
import com.proje.eTicaretSitesi.entities.BasketItem;

public interface IBasketProductRepository extends JpaRepository<BasketItem, Long> {
	List<BasketItem> findByBasket(Basket basket);
}
