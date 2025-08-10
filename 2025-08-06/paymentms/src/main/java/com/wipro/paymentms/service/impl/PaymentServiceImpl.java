package com.wipro.paymentms.service.impl;

import com.wipro.paymentms.entity.Payment;
import com.wipro.paymentms.repo.PaymentRepo;
import com.wipro.paymentms.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(int id) {
        return paymentRepo.findById(id);
    }

    @Override
    public void deletePaymentById(int id) {
        paymentRepo.deleteById(id);
    }
    
    @Override
    public Payment updatePayment(int id, Payment updatedPayment) {
        Optional<Payment> existing = getPaymentById(id);
        if (existing.isPresent()) {
            updatedPayment.setPaymentId(id); 
            return paymentRepo.save(updatedPayment);
        }
        return null;
    }
    
    @Override
    public List<Payment> getByOrderId(int orderId) {
        return paymentRepo.findByOrderId(orderId);
    }
}
