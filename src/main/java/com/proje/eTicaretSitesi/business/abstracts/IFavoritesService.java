package com.proje.eTicaretSitesi.business.abstracts;

import java.util.List;

import com.proje.eTicaretSitesi.entities.Favorites;

public interface IFavoritesService {
	List<Favorites> getUserFavoriteProducts (Long userId);
	Favorites addFavorite(Long userId, Long productId);
	void deleteFavorite(Long userId, Long productId);

}
