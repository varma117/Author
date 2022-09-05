package com.author.service;

import com.author.model.Author;
import com.book.model.Book;

public interface IAuthorService  {

	public Long createBook(Book book);
	
	public Long createAccount(Author author);
	
	public Book editBook(Book book,Long id);
	
}
