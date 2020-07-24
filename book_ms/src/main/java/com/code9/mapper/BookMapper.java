package com.code9.mapper;

import org.mapstruct.Mapper;

import com.code9.dto.BookDto;
import com.code9.model.BookEntity;

@Mapper(componentModel = "spring")
public interface BookMapper {
	
	BookEntity map(BookDto bookDto);
	
	BookDto mapToDto(BookEntity bookEntity);
}
