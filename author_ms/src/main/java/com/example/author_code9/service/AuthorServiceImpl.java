package com.example.author_code9.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.author_code9.dto.AuthorDto;
import com.example.author_code9.mapper.AuthorMapper;
import com.example.author_code9.model.AuthorEntity;
import com.example.author_code9.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	AuthorRepository authorRep;
	@Autowired
	AuthorMapper authorMapper;
	
	@Override
	public AuthorDto getAuthor(String firstName, String lastName) {
		final List<AuthorEntity> authorEntities=(List<AuthorEntity>)authorRep.findAuthor(firstName, lastName);
		final AuthorEntity authorEntity=authorEntities.get(0);
		final AuthorDto authorDto=authorMapper.mapToDto(authorEntity);
		return authorDto;
	}
	
}
