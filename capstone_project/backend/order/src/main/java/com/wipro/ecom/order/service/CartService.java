package com.wipro.ecom.order.service;

import com.wipro.ecom.order.dto.AddToCartRequest;
import com.wipro.ecom.order.entity.Cart;

public interface CartService {
    Cart getCartForUser(Long userId);
    Cart addToCart(Long userId, AddToCartRequest req);
    Cart updateCartItem(Long userId, Long cartItemId, int quantity);
    void deleteCartItem(Long userId, Long cartItemId);
    void clearCart(Long userId);
}
