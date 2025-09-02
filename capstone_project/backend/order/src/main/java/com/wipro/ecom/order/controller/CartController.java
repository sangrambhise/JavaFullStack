package com.wipro.ecom.order.controller;

import com.wipro.ecom.order.dto.AddToCartRequest;
import com.wipro.ecom.order.entity.Cart;
import com.wipro.ecom.order.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestBody AddToCartRequest req, HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        if (userId == null) return ResponseEntity.status(401).build();

        Cart updated = cartService.addToCart(userId, req);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<Cart> viewCart(HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        if (userId == null) return ResponseEntity.status(401).build();

        Cart cart = cartService.getCartForUser(userId);
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/update/{itemId}")
    public ResponseEntity<Cart> updateItem(@PathVariable Long itemId,
                                           @RequestParam int qty,
                                           HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        if (userId == null) return ResponseEntity.status(401).build();

        Cart updated = cartService.updateCartItem(userId, itemId, qty);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId, HttpServletRequest request) {
        Long userId = (Long) request.getAttribute("userId");
        if (userId == null) return ResponseEntity.status(401).build();

        cartService.deleteCartItem(userId, itemId);
        return ResponseEntity.noContent().build();
    }
}
