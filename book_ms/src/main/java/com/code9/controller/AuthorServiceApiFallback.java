package com.code9.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.code9.dto.AuthorDto;


@Component
public class AuthorServiceApiFallback implements AuthorServiceApi {

	public static final String UNKNOWN = "Unknown";

	@Override
	public AuthorDto getAuthor(final String firstName, final String lastName) {
		return new AuthorDto(null, UNKNOWN, UNKNOWN, LocalDate.now(), null);
	}
}
