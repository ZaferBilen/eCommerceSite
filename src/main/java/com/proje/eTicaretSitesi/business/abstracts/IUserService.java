package com.proje.eTicaretSitesi.business.abstracts;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.proje.eTicaretSitesi.business.requests.UserLoginRequest;
import com.proje.eTicaretSitesi.business.requests.UserRegisterRequest;
import com.proje.eTicaretSitesi.business.responses.GetUserProfileResponse;

public interface IUserService{
	
	void register(UserRegisterRequest register );
	void login(UserLoginRequest login);
	GetUserProfileResponse getCurrentUserProfile();
	void logout();

}
