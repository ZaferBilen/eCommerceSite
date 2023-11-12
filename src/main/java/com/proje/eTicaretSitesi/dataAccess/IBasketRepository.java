package com.proje.eTicaretSitesi.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proje.eTicaretSitesi.entities.Basket;
import com.proje.eTicaretSitesi.entities.User;

public interface IBasketRepository extends JpaRepository<Basket, Long>{
	List<Basket> findByUser(User user);

}
