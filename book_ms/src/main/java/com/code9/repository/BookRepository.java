package com.code9.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.code9.model.BookEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {
	
	@Query("UPDATE Book SET price=:price WHERE id=:id")
	public BookEntity updatePrice(@Param("price") BigDecimal price, @Param("id") Long id);
	
	@Query("select b from Book b inner join b.genres g where g.name= :name")
	public List<BookEntity> getBooksByGenre(@Param("name")String name);
	
	public List<BookEntity> findByTitle(String title);
	
	public List<BookEntity> findByAuthor(String author);
}
