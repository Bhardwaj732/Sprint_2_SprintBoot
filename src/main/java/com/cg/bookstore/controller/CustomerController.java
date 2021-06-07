package com.cg.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.repository.ICustomerRepository;
import com.cg.bookstore.service.ICustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	ICustomerService iCustomerService;

	@Autowired
	private ICustomerRepository iCustomerRepository;

	// create
	@PostMapping(path = "/createCustomer")
	@CrossOrigin(origins = "http://localhost:4200", methods = RequestMethod.POST)
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

		Customer o = iCustomerService.createCustomer(customer);
		return new ResponseEntity<Customer>(o, HttpStatus.OK);
	}

	// list
	@CrossOrigin(origins = "http://localhost:4200", methods = RequestMethod.GET)
	@GetMapping(path = "/getAllCustomers")
	public ResponseEntity<List<Customer>> listCustomer() {
		List<Customer> list = iCustomerService.listCustomers();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}

	@GetMapping(path = "/getCustomerById/{id}")
	@CrossOrigin(origins = "http://localhost:4200", methods = RequestMethod.GET)
	public Optional<Customer> getById(@PathVariable Integer id) {
		return iCustomerRepository.findById(id);
	}
	
	

	// delete
	@DeleteMapping(path = "/deleteCustomer")
	@CrossOrigin(origins = "http://localhost:4200", methods = RequestMethod.DELETE)
	public ResponseEntity<Customer> deleteCustomer(@RequestBody Customer customer) {
		Customer o = iCustomerService.deleteCustomer(customer);
		return new ResponseEntity<Customer>(o, HttpStatus.OK);
	}

	// update
	@PutMapping(path = "/updateCustomer")
	@CrossOrigin(origins = "http://localhost:4200", methods = RequestMethod.PUT)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		Customer o = iCustomerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(o, HttpStatus.OK);
	}

	// view
	@PostMapping(path = "/viewCustomers")
	@CrossOrigin(origins = "http://localhost:4200", methods = RequestMethod.POST)
	public ResponseEntity<Customer> viewCustomer(@RequestBody Customer customer) {
		Customer c = iCustomerService.viewCustomer(customer);
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}

	// delete
	@DeleteMapping(path = "/deleteCustomerById/{id}")
	@CrossOrigin(origins = "http://localhost:4200", methods = RequestMethod.DELETE)
	public ResponseEntity<List<Customer>> deleteCustomerById(@PathVariable Integer id) {
		List<Customer> customers = iCustomerService.deleteCustomerById(id);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

}
