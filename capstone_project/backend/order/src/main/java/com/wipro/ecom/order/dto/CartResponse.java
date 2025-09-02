package com.wipro.ecom.order.dto;
import com.wipro.ecom.order.entity.CartItem;
import lombok.Data;

import java.util.Set;

@Data
public class CartResponse {
    private Long id;
    private Long userId;
    private Set<CartItem> items;
}
