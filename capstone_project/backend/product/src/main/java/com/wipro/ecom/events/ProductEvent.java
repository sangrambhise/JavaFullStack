package com.wipro.ecom.events;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEvent implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long productId;
    private String action;
    private int stock;
}
