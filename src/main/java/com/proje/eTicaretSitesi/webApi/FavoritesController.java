package com.proje.eTicaretSitesi.webApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proje.eTicaretSitesi.business.abstracts.IFavoritesService;
import com.proje.eTicaretSitesi.business.requests.CreateFavoriteRequest;
import com.proje.eTicaretSitesi.business.responses.GetAllFavoritesResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController  //annotation yani bilgilendirme ifadesi 
@RequestMapping("/api/favorites")  //adresleme tarayıcadaki
@AllArgsConstructor
public class FavoritesController {
	
	private IFavoritesService favoritesService;
	
	@GetMapping("/get")
	public List<GetAllFavoritesResponse> getAll(){
		
		return favoritesService.GetAll();
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() @Valid()CreateFavoriteRequest createFavoriteRequest) {
		
		this.favoritesService.add(createFavoriteRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		this.favoritesService.delete(id);
	}
	
	

}
