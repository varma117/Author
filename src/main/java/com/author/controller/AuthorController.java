package com.author.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.author.model.Author;
import com.author.service.IAuthorService;
import com.book.model.Book;
import com.book.service.BookService;

@RestController
@RequestMapping("/digitalbooks")
@CrossOrigin(origins ="http://localhost:4200")
public class AuthorController {

	@Autowired
	IAuthorService authorService;
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/createbook")
	public Long createBook(@RequestBody Book book) {
		Long id = bookService.createBook(book);
		return id;
	}
	@PostMapping("/author/signup")
	public Long createAuthor(@RequestBody Author author) {
		Long id = authorService.createAccount(author);
		return id;
	}
	@GetMapping("/getallbooks")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@PutMapping("/editbook")
	public ResponseEntity<Book> editBook(@PathVariable("id") Long id ,@RequestBody Book book ){
		
	return  new ResponseEntity<Book>(bookService.editBook(book, id),HttpStatus.OK);
		
	}
	
}
