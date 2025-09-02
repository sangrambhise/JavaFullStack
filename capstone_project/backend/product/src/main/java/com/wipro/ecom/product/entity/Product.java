package com.wipro.ecom.product.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(nullable = false)
	    private String prodName;

	    private String prodDesc;

	    private String prodCat; 

	    private String make;

	    @Column(nullable = false)
	    private Integer availableQty;

	    @Column(nullable = false)
	    private Double price;

	    private String uom; 

	    private Double prodRating = 0.0;

	    private String imageURL;

	    private LocalDate dateOfManufacture;

	    private int stock; 
}
