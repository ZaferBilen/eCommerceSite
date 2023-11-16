package com.proje.eTicaretSitesi.business.responses;

import com.proje.eTicaretSitesi.entities.User.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllFavoritesResponse {

	private int id;
	private String productName;
	private int price;
}
