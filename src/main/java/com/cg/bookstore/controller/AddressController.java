package com.cg.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.Address;
import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.repository.AddressRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/address")
public class AddressController {
	
	@Autowired
	public AddressRepository addressRepository;
	
	
	@PostMapping(path = "/addAddress")
	public ResponseEntity<Address> addAddress(@RequestBody Address address) {

		Address add = addressRepository.save(address);
		return new ResponseEntity<Address>(add, HttpStatus.OK);
	}
}
