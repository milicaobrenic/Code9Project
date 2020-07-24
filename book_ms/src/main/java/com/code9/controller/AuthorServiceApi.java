package com.code9.controller;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code9.dto.AuthorDto;


@FeignClient(name = "author-code9", url = "http://localhost:8083", fallback = AuthorServiceApiFallback.class)
public interface AuthorServiceApi {

	@GetMapping(value = "/author", produces = MediaType.APPLICATION_JSON_VALUE)
	AuthorDto getAuthor(@RequestParam final String firstName, @RequestParam final String lastName);

}
