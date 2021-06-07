package com.cg.bookstore.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.BookCart;
import com.cg.bookstore.repository.ICartRepository;

@Service
public class CartServiceImplementation {
	
	@Autowired
	 private ICartRepository iCartRepository;
	
	
	
	public BookCart addQunatity(String title)
	{
		BookCart bookCart=iCartRepository.findByTitle(title);
		bookCart.setQuantity(bookCart.getQuantity()+1);
		iCartRepository.save(bookCart);
		return bookCart;
	}
	public BookCart decreaseQunatity(String title)
	{
		BookCart bookCart=iCartRepository.findByTitle(title);
		bookCart.setQuantity(bookCart.getQuantity()-1);
		if(bookCart.getQuantity()<1)
			iCartRepository.deleteByTitle(title);
		else
		iCartRepository.save(bookCart);
		return bookCart;
	}

}
