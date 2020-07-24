package com.example.author_code9.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.author_code9.model.AuthorEntity;

public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
	
	@Query("select a from AuthorEntity a where a.firstName like :firstName and a.lastName like :lastName")
	public List<AuthorEntity> findAuthor(@Param("firstName")String firstName, @Param("lastName")String lastName);
}
