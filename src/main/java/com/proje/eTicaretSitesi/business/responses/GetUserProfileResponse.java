package com.proje.eTicaretSitesi.business.responses;

import com.proje.eTicaretSitesi.entities.User.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserProfileResponse {
	private String name;
	private String surname;
	private String email;
	private UserRole role;
}
