package com.cg.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookstore.entities.BookCart;

@Repository
public interface ICartRepository extends JpaRepository<BookCart,String>{
	@Transactional
	@Modifying  
    @Query(value="delete from book_cart c where c.title=:title",nativeQuery=true)
	public int deleteByTitle(@Param("title") String title);
	
	@Query(value="select * from book_cart c where c.title=:title",nativeQuery=true)
	public BookCart findByTitle(@Param("title") String title);

}
