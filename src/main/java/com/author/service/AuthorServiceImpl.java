package com.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.UpdateBuilder;
import org.springframework.stereotype.Service;

import com.author.exceptionhandling.ResourceNotFoundException;
import com.author.model.Author;
import com.author.repository.AuthorRepository;
import com.book.model.Book;
import com.book.repository.BookRepositoty;

@Service
public class AuthorServiceImpl implements IAuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	BookRepositoty bookRepo;
	
	@Override
	public Long createBook(Book book) {
		Book newBook = bookRepo.save(book);
		return newBook.getId();
	}

	@Override
	public Long createAccount(Author author) {
		Author newAuthor = authorRepository.save(author);
		return newAuthor.getId();
	}

	@Override
	public Book editBook(Book book,Long id) {
		
		Book updatedBook = bookRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Book", "id", id) );
		updatedBook.setBookName(book.getBookName());
		updatedBook.setCategory(book.getCategory());
		updatedBook.setContent(book.getContent());
		updatedBook.setLogo(book.getLogo());
		updatedBook.setPrice(book.getPrice());
		updatedBook.setPublishedDate(book.getPublishedDate());
		updatedBook.setPublisher(book.getPublisher());
		updatedBook.setStatus(book.isStatus());
		updatedBook.setAuthorName(book.getAuthorName());
		
		bookRepo.save(updatedBook);
		return updatedBook;
	}
	

}
