package com.proje.eTicaretSitesi.business.abstracts;

import com.proje.eTicaretSitesi.entities.Cart;

import jakarta.servlet.http.HttpSession;

public interface GuestCartService {
	public void createCartForUser(HttpSession session);
	public Cart getCartFromSession(HttpSession session);
	public void clearCartFromSession(HttpSession session);
}
