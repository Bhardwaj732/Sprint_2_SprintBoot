package com.cg.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.Payment;
import com.cg.bookstore.repository.PaymentRepository;

@RestController
@RequestMapping("/BookManagement")
@CrossOrigin
public class PaymentController {
	@Autowired
	PaymentRepository paymentRepository;
	
	@PostMapping(path="/doPayment")
	public String addPayment(@RequestBody Payment payment)
	{
		paymentRepository.save(payment);
		return "Added payment";
	}
	@GetMapping(path="/getDetails")
	public List<Payment> getDetails()
	{
		return paymentRepository.findAll();
		
	}

}
