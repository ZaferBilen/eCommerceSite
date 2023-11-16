package com.proje.eTicaretSitesi.business.abstracts;

import java.util.List;

import com.proje.eTicaretSitesi.business.requests.CreateFavoriteRequest;
import com.proje.eTicaretSitesi.business.responses.GetAllFavoritesResponse;

public interface IFavoritesService {
	
	List<GetAllFavoritesResponse> GetAll();
	void add(CreateFavoriteRequest createFavoriteRequest);
	void delete(long id);
	}