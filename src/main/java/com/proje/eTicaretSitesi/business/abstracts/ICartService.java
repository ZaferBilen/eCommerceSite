package com.proje.eTicaretSitesi.business.abstracts;

import com.proje.eTicaretSitesi.entities.Cart;
import com.proje.eTicaretSitesi.entities.User;

public interface ICartService {
	 Cart createCartForUser(User user);
}
