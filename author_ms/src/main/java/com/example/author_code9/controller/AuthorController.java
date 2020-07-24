package com.example.author_code9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.author_code9.dto.AuthorDto;
import com.example.author_code9.service.AuthorService;

@RestController
@RequestMapping("author")
public class AuthorController {

	private final AuthorService authorService;
	
	@Autowired
	public AuthorController(final AuthorService authorService) {
		this.authorService = authorService;
	}
	
	@GetMapping
	public AuthorDto getAuthor(@RequestParam final String firstName, @RequestParam final String lastName) {
		return authorService.getAuthor(firstName, lastName);
	}
}
