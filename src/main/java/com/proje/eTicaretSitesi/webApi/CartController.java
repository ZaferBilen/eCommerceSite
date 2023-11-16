package com.proje.eTicaretSitesi.webApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proje.eTicaretSitesi.business.abstracts.GuestCartService;
import com.proje.eTicaretSitesi.business.abstracts.ICartService;
import com.proje.eTicaretSitesi.entities.Cart;
import com.proje.eTicaretSitesi.entities.User;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api") 
@AllArgsConstructor
public class CartController {
	private ICartService cartService;
	private GuestCartService guestCartService;
	
	@PostMapping("/user/cart/create")
	public Cart createCartForUser (User user) {
		
		return cartService.createCartForUser(user);
	}
	
	@PostMapping("/guest/cart/create")
	public void createCartForGuest(HttpSession session) {
        guestCartService.createCartForUser(session);
    }
	@GetMapping("/guest/cart")
    public Cart getCartFromSession(HttpSession session) {
        return guestCartService.getCartFromSession(session);
    }
	 @PostMapping("/guest/cart/clear")
	    public void clearCartFromSession(HttpSession session) {
	        guestCartService.clearCartFromSession(session);
	    }
	
}
