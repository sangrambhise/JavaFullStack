package com.wipro.paymentms.service;

import com.wipro.paymentms.entity.Payment;
import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment savePayment(Payment payment);
    List<Payment> getAllPayments();
    Optional<Payment> getPaymentById(int id);
    void deletePaymentById(int id);
    Payment updatePayment(int id, Payment updatedPayment);
    List<Payment> getByOrderId(int orderId);

}
