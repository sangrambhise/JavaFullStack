package com.wipro.productApi.service.impl;

import com.wipro.productApi.entity.Product;
import com.wipro.productApi.entity.Order;
import com.wipro.productApi.repo.OrderRepo;
import com.wipro.productApi.repo.ProductRepo;
import com.wipro.productApi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
//Ex3
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo;

    
    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(int id) {
        Optional<Product> opt = productRepo.findById(id);
        return opt.orElse(null);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteById(int id) {
        productRepo.deleteById(id);
    }
    
    @Override
    public boolean purchase(int productId, int qty) {
      Optional<Product> opt = productRepo.findById(productId);
      if (opt.isPresent() && opt.get().getQty() >= qty) {
        Product p = opt.get();
        p.setQty(p.getQty() - qty);
        productRepo.save(p);

        Order order = new Order();
        order.setProductId(p.getId());
        order.setProductName(p.getName());
        order.setQtyPurchased(qty);
        order.setOrderDate(LocalDateTime.now());
        orderRepo.save(order);
        return true;
      }
      return false;
    }
    
    @Override
    public List<Order> getOrders() {
        return orderRepo.findAll();
    }


}
