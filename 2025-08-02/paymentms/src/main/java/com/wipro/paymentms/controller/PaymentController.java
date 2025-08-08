package com.wipro.paymentms.controller;
import com.wipro.paymentms.entity.Payment;
import com.wipro.paymentms.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	private HttpHeaders createdAtHeader() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("created-at", LocalDate.now().toString());
	    return headers;
	}

	private HttpHeaders searchTimeHeader() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("search-time", LocalDateTime.now().toString());
	    return headers;
	}
	
	private HttpHeaders modifiedAtHeader() {
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("modified-at", LocalDateTime.now().toString());
	    return headers;
	}
	
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Payment payment) {
    		payment.setPaymentStatus(true);
    		paymentService.savePayment(payment);
        return ResponseEntity
                .status(201)
                .headers(createdAtHeader())
                .body("Data Saved Successfully");
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Payment> payments = paymentService.getAllPayments();
        if (payments.isEmpty()) {
            return ResponseEntity
                    .status(404)
                    .headers(searchTimeHeader())
                    .body("No payments found");
        } else {
            return ResponseEntity
                    .ok()
                    .headers(searchTimeHeader())
                    .body(payments);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Optional<Payment> payment = paymentService.getPaymentById(id);
        if (payment.isPresent()) {
            return ResponseEntity
                    .ok()
                    .headers(searchTimeHeader())
                    .body(payment.get());
        } else {
            return ResponseEntity
                    .status(404)
                    .headers(searchTimeHeader())
                    .body("Payment not found for ID: " + id);
        }
    }
    
    

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        Optional<Payment> payment = paymentService.getPaymentById(id);

        if (payment.isPresent()) {
            paymentService.deletePaymentById(id);
            return ResponseEntity
                    .ok()
                    .headers(modifiedAtHeader())
                    .body("Data Deleted Successfully");
        } else {
            return ResponseEntity
                    .status(404)
                    .headers(modifiedAtHeader())
                    .body("Payment not found with ID: " + id);
        }
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Payment updatedPayment) {
        Payment result = paymentService.updatePayment(id, updatedPayment);

        if (result != null) {
            return ResponseEntity
                    .ok()
                    .headers(modifiedAtHeader())
                    .body("Data Modified Successfully");
        } else {
            return ResponseEntity
                    .status(404)
                    .headers(modifiedAtHeader())
                    .body("Payment not found with ID: " + id);
        }
    }
    
    @GetMapping("/byOrderId/{orderId}")
    public ResponseEntity<List<Payment>> getByOrderId(@PathVariable int orderId) {
        List<Payment> payments = paymentService.getByOrderId(orderId);
        return ResponseEntity.ok(payments);
    }

}
