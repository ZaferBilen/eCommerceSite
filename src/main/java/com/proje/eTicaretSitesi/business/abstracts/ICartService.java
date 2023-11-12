package com.proje.eTicaretSitesi.business.abstracts;

import com.proje.eTicaretSitesi.entities.Cart;
import com.proje.eTicaretSitesi.entities.CartItem;

public interface ICartService {
	Cart getUserCart(long userId); // kullanıcı sepeti getir
	CartItem AddProduct(Long cartId,long productId, int quantity);  // sepete ürün ekle
	void clearCart(Long cartId); //sepeti sil.
}
