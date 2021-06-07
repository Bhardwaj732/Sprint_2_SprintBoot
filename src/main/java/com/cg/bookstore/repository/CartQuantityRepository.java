package com.cg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.CartQuantity;

@Repository
public interface CartQuantityRepository extends JpaRepository<CartQuantity, Integer>{

}
