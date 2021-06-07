package com.cg.bookstore.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.ContactUs;
import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.repository.IContactRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/contactUs")
public class ContactUsController {

	
	@Autowired
	private IContactRepository iContactRepository;
	
	
	// add new details 
	@PostMapping(path = "/addContactUs")
	public ResponseEntity<ContactUs> addContactUs(@RequestBody ContactUs contact) {
		contact.setDate(LocalDate.now());
		ContactUs  contactUs= iContactRepository.save(contact);
		return new ResponseEntity<ContactUs>(contactUs, HttpStatus.OK);
	}

	// list all contactUs
	@GetMapping(path = "/getAllContactUs")
	public ResponseEntity<List<ContactUs>> getAllContactUs() {
		List<ContactUs>  contactUs = iContactRepository.findAll();
		return new ResponseEntity<List<ContactUs>>(contactUs, HttpStatus.OK);
	}
	
	
	//delete contactUs
	@DeleteMapping(path = "/deleteContactUs/{id}")
	public ResponseEntity<List<ContactUs>> deleteContactUs(@PathVariable Integer id) {
		iContactRepository.deleteById(id);
		return new ResponseEntity<List<ContactUs>>(iContactRepository.findAll(), HttpStatus.OK);
	}
}
