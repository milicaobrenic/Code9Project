package com.code9.service;

import java.math.BigDecimal;
import java.util.List;

import com.code9.dto.BookDto;
import com.code9.dto.GenreDto;

public interface BookService {
	BookDto save(BookDto book);
	
	BookDto getById(Long id);
	
	BookDto updatePrice(Long id, BigDecimal price);
	
	int stockCount(String title);
	
	boolean checkStock(String title);
	
	List<BookDto> getByGenre(String genreName);

	List<BookDto> getByTitle(String title);
	  
	List<BookDto> getByAuthor(String author);
	  
	List<GenreDto> getCategoriesOfBooks();
	  
	List<BookDto> top10Books();
	
	  
	
}
