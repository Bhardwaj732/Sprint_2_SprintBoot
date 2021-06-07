package com.cg.bookstore.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.BookOrder;
import com.cg.bookstore.repository.BookOrderRepository;
@RestController
@RequestMapping("/BookManagement")
@CrossOrigin
public class BookOrderController {

	@Autowired
	BookOrderRepository iBookOrderRepository;
	
	@PostMapping(path="/addBookOrder")
	public String addBookOrder(@RequestBody BookOrder bookOrder)
	{
		bookOrder.setOrderDate(LocalDate.now());
		iBookOrderRepository.save(bookOrder);
		return "Order Added";
	}
	@GetMapping(path = "/getAllOrders")
	public ResponseEntity<List<BookOrder>> listCustomer() {

		List<BookOrder> list = iBookOrderRepository.findAll();
		return new ResponseEntity<List<BookOrder>>(list, HttpStatus.OK);
	}

	@GetMapping(path = "/getOrder/{orderId}")
	public BookOrder listCustomer(@PathVariable Integer orderId) {
		Optional<BookOrder> list = iBookOrderRepository.findById(orderId);
		return list.get();
	}

}
