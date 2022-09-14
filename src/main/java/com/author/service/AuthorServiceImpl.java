package com.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.author.model.Author;
import com.author.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements IAuthorService {

	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public Long createAccount(Author author) {
		Author newAuthor = authorRepository.save(author);
		return newAuthor.getId();
	}


}
