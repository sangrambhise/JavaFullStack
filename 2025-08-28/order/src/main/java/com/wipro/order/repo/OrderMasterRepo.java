package com.wipro.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wipro.order.entity.OrderMaster;

 

@Repository
public interface OrderMasterRepo extends JpaRepository<OrderMaster, Integer> {

}
