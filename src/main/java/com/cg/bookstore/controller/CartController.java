package com.cg.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.BookCart;
import com.cg.bookstore.repository.ICartRepository;
import com.cg.bookstore.serviceImp.CartServiceImplementation;


@RestController
@RequestMapping("/BookManagement")
@CrossOrigin
public class CartController {
	
	  @Autowired
	  ICartRepository iCartRepository;
	  
	  @Autowired
	  CartServiceImplementation cartServiceImplementation;
	  
	  @PostMapping(path="/addToCart")
	  public BookCart addToCart(@RequestBody BookCart cart) {
		  return iCartRepository.save(cart);
	  }
	  
	  @GetMapping(path="/showCart")
	  public List<BookCart> showCart() {
		  return iCartRepository.findAll();
	  }
	  @DeleteMapping(path="/deleteBookFromCart/{title}")
	  public String deleteBookFromCart(@PathVariable String title)
	  {
		 iCartRepository.deleteByTitle(title);
		 return "Deleted";
	  }
	  @PutMapping(path="/addQuantity/{title}")
	  public BookCart addQuantity(@PathVariable String title) {
		  BookCart b=cartServiceImplementation.addQunatity(title);
		  return b;
	  }
	  @PutMapping(path="/decreaseQuantity/{title}")
	  public BookCart deleteQuantity(@PathVariable String title) {
		  BookCart b=cartServiceImplementation.decreaseQunatity(title);
		  return b;
	  }

	  

}
