package com.proje.eTicaretSitesi.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proje.eTicaretSitesi.entities.Cart;
import com.proje.eTicaretSitesi.entities.User;

public interface ICartRepository extends JpaRepository<Cart, Long>{
	List<Cart> findByUser(User user);

}
