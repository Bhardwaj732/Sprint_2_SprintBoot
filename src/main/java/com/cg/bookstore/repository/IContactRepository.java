package com.cg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.ContactUs;

@Repository
public interface IContactRepository extends JpaRepository<ContactUs, Integer> {

}
