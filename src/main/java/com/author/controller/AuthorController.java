package com.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.author.model.Author;
import com.author.service.IAuthorService;
import com.book.model.Book;

@RestController
@RequestMapping("/digitalbooks")
@CrossOrigin(origins ="http://localhost:4200")
public class AuthorController {

	@Autowired
	IAuthorService authorService;
	
	@PostMapping("/createbook")
	public Long createBook(@RequestBody Book book) {
		Long id = authorService.createBook(book);
		return id;
	}
	@PostMapping("/author/signup")
	public Long createAuthor(@RequestBody Author author) {
		Long id = authorService.createAccount(author);
		return id;
	}
}
