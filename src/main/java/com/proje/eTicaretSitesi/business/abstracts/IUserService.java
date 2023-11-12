package com.proje.eTicaretSitesi.business.abstracts;

import com.proje.eTicaretSitesi.entities.User;

public interface IUserService {
	
	User register(User user);
	User login(String email, String password);
	User googleIleGiris(String googleIdToken);

}
