package com.author.service;

import java.util.List;

import com.author.model.Author;
import com.book.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
@Component
public interface IAuthorService  {
	
	public Long createAccount(Author author);
	
}
