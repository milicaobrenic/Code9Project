package com.code9.dto;

import java.math.BigDecimal;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BookDto {
	private long id;
	private String title;
	private String author;
	private BigDecimal price;
	private int stockNumber;
	private boolean outOfStockFlag;
	private int totalCopies;
	private int soldCopies;
	
	public static Comparator<BookDto> soldCopiesComparator = new Comparator<BookDto>() {

		public int compare(BookDto b1, BookDto b2) {

		   int sold1 = b1.getSoldCopies();
		   int sold2 = b2.getSoldCopies();

		   return sold2-sold1;  
	   }};
}
