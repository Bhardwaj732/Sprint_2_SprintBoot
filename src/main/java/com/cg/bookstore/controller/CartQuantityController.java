package com.cg.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.CartQuantity;
import com.cg.bookstore.repository.CartQuantityRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cartQuantity")
public class CartQuantityController {
	 private int temp=0;
	
	@Autowired
	private CartQuantityRepository cartQuantityRepository;
	
	
	@GetMapping(path = "/getCartValue/{customerId}")
	public Integer getCartValue(@PathVariable Integer customerId) {
		CartQuantity cartQuantity = cartQuantityRepository.findById(customerId).get();
		if(cartQuantity != null) {
			temp = cartQuantity.getCartValue();
		}
		return temp;
	}
	
	
	@PutMapping(path = "/increaseCartValue")
	public CartQuantity increaseCartValue(@RequestBody CartQuantity cartQuantity) {
		temp = cartQuantity.getCartValue();
		temp = temp +1;
		cartQuantity.setCartValue(temp);
		cartQuantityRepository.save(cartQuantity);
		return cartQuantity;
	}
	
	
	@PutMapping(path = "/decreasedCartValue")
	public CartQuantity decreasedCartValue(@RequestBody CartQuantity cartQuantity) {
		temp = cartQuantity.getCartValue();
		temp = temp - 1;
		cartQuantity.setCartValue(temp);
		cartQuantityRepository.save(cartQuantity);
		return cartQuantity;
	}

}
