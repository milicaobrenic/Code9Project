package com.example.author_code9.service;

import com.example.author_code9.dto.AuthorDto;

public interface AuthorService {

	AuthorDto getAuthor(String firstName, String lastName);
}
