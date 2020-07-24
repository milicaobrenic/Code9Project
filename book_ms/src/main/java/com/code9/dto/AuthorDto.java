package com.code9.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class AuthorDto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	
	private Long bookId;
}
