package com.code9.mapper;

import org.mapstruct.Mapper;

import com.code9.dto.GenreDto;
import com.code9.model.GenreEntity;


@Mapper(componentModel = "spring")
public interface GenreMapper {

	GenreEntity map(GenreDto genreDto);

	GenreDto mapToDto(GenreEntity genreEntity);
}
