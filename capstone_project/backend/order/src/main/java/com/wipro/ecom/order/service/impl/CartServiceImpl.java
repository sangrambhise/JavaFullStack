package com.wipro.ecom.order.service.impl;

import com.wipro.ecom.order.dto.AddToCartRequest;
import com.wipro.ecom.order.entity.Cart;
import com.wipro.ecom.order.entity.CartItem;
import com.wipro.ecom.order.repo.CartRepository;
import com.wipro.ecom.order.service.CartService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private static final String CB_NAME = "defaultCB";

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @CircuitBreaker(name = CB_NAME, fallbackMethod = "getCartFallback")
    public Cart getCartForUser(Long userId) {
        return cartRepository.findByUserId(userId).orElseGet(() -> {
            Cart c = Cart.builder().userId(userId.intValue()).build();
            return cartRepository.save(c);
        });
    }

    public Cart getCartFallback(Long userId, Throwable ex) {
        return Cart.builder()
                   .userId(userId.intValue())
                   .build(); 
    }
    
    @Override
    @CircuitBreaker(name = CB_NAME, fallbackMethod = "cartOperationFallback")
    public Cart addToCart(Long userId, AddToCartRequest req) {
        Cart cart = getCartForUser(userId);
        Optional<CartItem> existing = cart.getItems().stream()
                .filter(i -> i.getProductId().equals(req.getProductId()))
                .findFirst();

        if (existing.isPresent()) {
            existing.get().setQuantity(existing.get().getQuantity() + req.getQuantity());
        } else {
            CartItem item = CartItem.builder()
                    .productId(req.getProductId().intValue())
                    .quantity(req.getQuantity())
                    .cart(cart)
                    .build();
            cart.getItems().add(item);
        }
        return cartRepository.save(cart);
    }

    public Cart cartOperationFallback(Long userId, AddToCartRequest req, Throwable ex) {
        return Cart.builder()
                   .userId(userId.intValue())
                   .build(); 
    }
    
    @Override
    public Cart updateCartItem(Long userId, Long cartItemId, int quantity) {
        Cart cart = getCartForUser(userId);
        cart.getItems().stream()
            .filter(i -> i.getId().equals(cartItemId))
            .findFirst()
            .ifPresent(i -> i.setQuantity(quantity));
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCartItem(Long userId, Long cartItemId) {
        Cart cart = getCartForUser(userId);
        cart.getItems().removeIf(i -> i.getId().equals(cartItemId));
        cartRepository.save(cart);
    }

    @Override
    public void clearCart(Long userId) {
        Cart cart = getCartForUser(userId);
        cart.getItems().clear();
        cartRepository.save(cart);
    }
}
