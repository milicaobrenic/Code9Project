package com.code9.repository;

import org.springframework.data.repository.CrudRepository;

import com.code9.model.GenreEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<GenreEntity, Long> {
}
