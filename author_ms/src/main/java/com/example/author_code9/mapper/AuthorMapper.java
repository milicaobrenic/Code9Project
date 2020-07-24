package com.example.author_code9.mapper;


import org.mapstruct.Mapper;

import com.example.author_code9.dto.AuthorDto;
import com.example.author_code9.model.AuthorEntity;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

	AuthorEntity map(AuthorDto authorDto);

	AuthorDto mapToDto(AuthorEntity authorEntity);
 

}
