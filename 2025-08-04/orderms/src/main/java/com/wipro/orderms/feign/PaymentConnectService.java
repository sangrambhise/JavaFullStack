package com.wipro.orderms.feign;

import com.wipro.orderms.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "paymentms")
public interface PaymentConnectService {

    @PostMapping("/payments")
    ResponseEntity<String> savePaymentData(@RequestBody Payment payment);

    @GetMapping("/payments/byOrderId/{orderId}")
    List<Payment> getPaymentsByOrderId(@PathVariable int orderId);
}

