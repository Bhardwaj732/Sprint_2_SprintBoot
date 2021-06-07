package com.cg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,String>{

}
