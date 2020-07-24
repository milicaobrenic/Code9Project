package com.code9.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code9.dto.BookDto;
import com.code9.dto.CartDto;
import com.code9.dto.GenreDto;
import com.code9.mapper.BookMapper;
import com.code9.mapper.GenreMapper;
import com.code9.model.BookEntity;
import com.code9.model.GenreEntity;
import com.code9.repository.BookRepository;
import com.code9.repository.GenreRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	public BookRepository bookRep;
	@Autowired
	private GenreRepository genreRep;
	@Autowired
	private BookMapper bookMapper;
	@Autowired
	private GenreMapper genreMapper;
	
	@Override
	public BookDto save(final BookDto bookDto) {
		final BookEntity bookEntityToSave = bookMapper.map(bookDto);
	    final BookEntity savedBook = bookRep.save(bookEntityToSave);
	    final BookDto savedBookDto = bookMapper.mapToDto(savedBook);
	    return savedBookDto;
	}
	
	@Override
	public BookDto getById(final Long id) {
		final BookEntity foundBookEntity = bookRep.findById(id).get();
	    final BookDto foundBookDto = bookMapper.mapToDto(foundBookEntity);
	    return foundBookDto;
	}
	
	
	@Override
	public BookDto updatePrice(Long id, BigDecimal price) {
		final BookEntity bookEntity = bookRep.updatePrice(price, id);
		
		return bookMapper.mapToDto(bookEntity);
	}
	
	@Override
	public int stockCount(String title) {
		final List<BookEntity> bookEntities = bookRep.findByTitle(title);
		int count = 0;
		
		if (bookEntities != null) {
			for (BookEntity bookEntity : bookEntities) {
				count++;
			}
		}
		
		BookDto bookD = bookMapper.mapToDto(bookRep.findByTitle(title).get(0));
		bookD.setStockNumber(count);
		
		return count;
	}
	
	@Override
	public boolean checkStock(String title) {
		final List<BookEntity> bookEntities = bookRep.findByTitle(title);
		boolean isEmpty = false;
		
		if (bookEntities != null) {
			isEmpty = bookEntities.get(0).getStockNumber() == 0 ? true : false;
		}
		
		if (isEmpty == true) {
			for (BookEntity bookEntity : bookEntities) {
				bookEntity.setOutOfStockFlag(true);
			}
		}

		return isEmpty;
	}
	
	  @Override
	  public List<BookDto> getByGenre(String genreName) {
		List<BookEntity>  foundBookEntities=bookRep.getBooksByGenre(genreName);
		List<BookDto> bookDtoList=new ArrayList<>();
		for(BookEntity b:foundBookEntities) {
			BookDto bookDto = bookMapper.mapToDto(b);
			bookDtoList.add(bookDto);
		}
		return bookDtoList;
	}

	  @Override
	  public List<BookDto> getByTitle(String title) {
		  final List<BookEntity> foundBookEntities = bookRep.findByTitle(title);
		  List<BookDto> bookDtoList=new ArrayList<>();
			for(BookEntity b:foundBookEntities) {
				BookDto bookDto = bookMapper.mapToDto(b);
				bookDtoList.add(bookDto);
			}
			return bookDtoList; 
	  }

	  @Override
	  public List<BookDto> getByAuthor(String author) {
		  final List<BookEntity> foundBookEntities = bookRep.findByAuthor(author);
		  List<BookDto> bookDtoList=new ArrayList<>();
			for(BookEntity b:foundBookEntities) {
				BookDto bookDto = bookMapper.mapToDto(b);
				bookDtoList.add(bookDto);
			}
			return bookDtoList; 
	  }

	  @Override
	  public List<GenreDto> getCategoriesOfBooks() {
		  final List<GenreEntity> foundGenreEntities =(List<GenreEntity>) genreRep.findAll();
		  List<GenreDto> genreDtoList=new ArrayList<>();
			for(GenreEntity g:foundGenreEntities) {
				GenreDto genreDto = genreMapper.mapToDto(g);
				genreDtoList.add(genreDto);
			}
			return genreDtoList; 
	  }

	  @Override
	  public List<BookDto> top10Books() {
		  final List<BookEntity> foundBookEntities = (List<BookEntity>) bookRep.findAll();
		  List<BookDto> bookDtoList=new ArrayList<>();
		  for(BookEntity b:foundBookEntities) {
			  BookDto bookDto = bookMapper.mapToDto(b);
			  bookDtoList.add(bookDto);
		  }
		  Collections.sort(bookDtoList, BookDto.soldCopiesComparator);
		  List<BookDto> topTen=new ArrayList<>();
		  for(int i=0;i<10;i++) {
			  topTen.add(bookDtoList.get(i));
		  }
		  return topTen; 
	  }

	 
	  
}