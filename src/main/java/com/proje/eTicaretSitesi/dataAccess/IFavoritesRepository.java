package com.proje.eTicaretSitesi.dataAccess;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proje.eTicaretSitesi.entities.Favorites;
import com.proje.eTicaretSitesi.entities.Product;
import com.proje.eTicaretSitesi.entities.User;

public interface IFavoritesRepository extends JpaRepository<Favorites, Long> {
	List<Favorites> findByUser(User user);
	Optional<Favorites> findByUserAndProduct(User user, Product product);

}
