package com.code9.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Book")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private BigDecimal price;
	private int totalCopies;  
	private int soldCopies;
	private int stockNumber;
	private boolean outOfStockFlag;

	@ManyToMany
	@JoinTable(name = "Genre_Books", joinColumns = {@JoinColumn(name = "book_id")},
     inverseJoinColumns = {@JoinColumn(name = "genre_id")})
	private Set<GenreEntity> genres;
	
	
}
