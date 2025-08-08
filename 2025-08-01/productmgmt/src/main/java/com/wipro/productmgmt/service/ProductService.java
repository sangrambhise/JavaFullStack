package com.wipro.productmgmt.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.wipro.productmgmt.entity.Product;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
    Product findById(int id);
    void deleteById(int id);
    List<Product> findByProductMake(String productMake);
    List<Product> findByProductNameAndProductMake(String productName, String productMake);
    Page<Product> getProductsPaginatedSortedByPrice(Pageable pageable);

}
