package com.code9.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code9.dto.BookDto;
import com.code9.dto.GenreDto;
import com.code9.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	@Autowired
	BookService bookService;
	
	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> save(@RequestBody final BookDto book) {
		final BookDto response = bookService.save(book);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping
	public BookDto getBook(@RequestBody final Long id) {
		return bookService.getById(id);
	}
	
	@GetMapping(path = "/updatePrice/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> updatePrice(@RequestBody Long id,@PathVariable BigDecimal price){
		final BookDto response = bookService.updatePrice(id, price);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "/stockCount/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> stockCount(@RequestBody String title) {
		final Integer response = bookService.stockCount(title);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/checkStock/{title}", produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Boolean> checkStock(@PathVariable String title) {
		final Boolean response = bookService.checkStock(title);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getBooksGenre/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookDto>> getBooksGenre(@PathVariable final String name) {
		final List<BookDto> response = bookService.getByGenre(name);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getBooksTitle/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookDto>> getBooksTitle(@PathVariable final String title) {
		final List<BookDto> response = bookService.getByTitle(title);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getBooksAuthor/{author}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookDto>> getBooksAuthor(@PathVariable final String author) {
		final List<BookDto> response = bookService.getByAuthor(author);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getCategories", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GenreDto>> getCategoriesOfBooks() {
		final List<GenreDto> response = bookService.getCategoriesOfBooks();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getTopTen", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookDto>> getTopTenBooks() {
		final List<BookDto> response = bookService.top10Books();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
}
