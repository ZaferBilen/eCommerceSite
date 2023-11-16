package com.proje.eTicaretSitesi.business.concretes;

import org.springframework.stereotype.Service;

import com.proje.eTicaretSitesi.business.abstracts.GuestCartService;
import com.proje.eTicaretSitesi.business.abstracts.ICartService;
import com.proje.eTicaretSitesi.dataAccess.ICartRepository;
import com.proje.eTicaretSitesi.entities.Cart;
import com.proje.eTicaretSitesi.entities.User;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartManager implements ICartService, GuestCartService{

    private ICartRepository cartRepository;
    

    @Override
    public Cart createCartForUser(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

	@Override
	public void createCartForUser(HttpSession session) {
		Cart cart = new Cart();
        session.setAttribute("cart", cart); 
    }

	@Override
	public Cart getCartFromSession(HttpSession session) {
	     
		return (Cart) session.getAttribute("cart"); 
		
	 }
	
	@Override
	public void clearCartFromSession(HttpSession session) {
	    
		session.removeAttribute("cart"); 
		
	 }

}
