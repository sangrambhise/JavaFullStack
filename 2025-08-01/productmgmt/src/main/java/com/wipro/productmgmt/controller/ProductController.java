package com.wipro.productmgmt.controller;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.wipro.productmgmt.entity.Product;
import com.wipro.productmgmt.service.ProductService;
@Tag(name = "Tutorial", description = "Tutorial management APIs")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Operation(summary = "Save a tourist place")
	  @ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Saved successfully"),
	    @ApiResponse(responseCode = "404", description = "Not found")
	  })
    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteById(id);
    }
    
    @GetMapping("/make/{productMake}")
    public List<Product> getProductsByMake(@PathVariable String productMake) {
        return productService.findByProductMake(productMake);
    }
    @GetMapping("/search/{productName}/{productMake}")
    public List<Product> getProductsByNameAndMake(@PathVariable String productName, @PathVariable String productMake) {
        return productService.findByProductNameAndProductMake(productName, productMake);
    }
    
    @GetMapping("/page/{page}/{size}/{desc}")
    public Page<Product> getProductsPaginatedSorted(
            @PathVariable int page,
            @PathVariable int size,
            @PathVariable int desc) {

        Sort sort;
        if (desc == 1) {
            sort = Sort.by("productPrice").descending();
        } else {
            sort = Sort.by("productPrice").ascending();
        }

        Pageable pageable = PageRequest.of(page, size, sort);
        return productService.getProductsPaginatedSortedByPrice(pageable);
    }
}

