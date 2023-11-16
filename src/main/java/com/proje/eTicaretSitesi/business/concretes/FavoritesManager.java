package com.proje.eTicaretSitesi.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proje.eTicaretSitesi.business.abstracts.IFavoritesService;
import com.proje.eTicaretSitesi.business.requests.CreateFavoriteRequest;
import com.proje.eTicaretSitesi.business.responses.GetAllFavoritesResponse;
import com.proje.eTicaretSitesi.core.utilities.mappers.IModelMapperService;
import com.proje.eTicaretSitesi.dataAccess.IFavoritesRepository;
import com.proje.eTicaretSitesi.entities.Favorites;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FavoritesManager implements IFavoritesService {

	private IFavoritesRepository favoritesRepository;
	private IModelMapperService modelMapperService;
	
	
	@Override
	public List<GetAllFavoritesResponse> GetAll() {
		List<Favorites> favoritess = favoritesRepository.findAll();
		
		List<GetAllFavoritesResponse> favoritesResponse = favoritess.stream()
				.map(favorites ->this.modelMapperService.forResponse()
						.map(favorites, GetAllFavoritesResponse.class)).collect(Collectors.toList());
		
		return favoritesResponse;
	}

	@Override
	public void add(CreateFavoriteRequest createFavoriteRequest) {
		
		Favorites favorites= this.modelMapperService.forRequest().map(createFavoriteRequest, Favorites.class);
		this.favoritesRepository.save(favorites);
		
	}

	@Override
	public void delete(long id) {
		
		this.favoritesRepository.deleteById(id);
		
	}

}
