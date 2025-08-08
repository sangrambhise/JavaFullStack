package com.wipro.productmgmt.service.impl;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.wipro.productmgmt.entity.Product;
import com.wipro.productmgmt.repo.ProductRepository;
import com.wipro.productmgmt.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductRepository repo;

    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Product findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        repo.deleteById(id);
    }
    
    @Override
    public List<Product> findByProductMake(String productMake) {
        return repo.findByProductMake(productMake);
    }
    @Override
    public List<Product> findByProductNameAndProductMake(String productName, String productMake) {
        return repo.findByProductNameAndProductMakeOrderByProductNameDesc(productName, productMake);
    }
    @Override
    public Page<Product> getProductsPaginatedSortedByPrice(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
