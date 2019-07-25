package com.gcit.training.hibernatejpaapp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.training.hibernatejpaapp.dao.AuthorDao;
import com.gcit.training.hibernatejpaapp.entity.Author;
import com.gcit.training.hibernatejpaapp.entity.Author;

@RestController
@RequestMapping("/lms")
public class AuthorController {
	@Autowired
	private AuthorDao authorDao;
	@GetMapping("/author")
	public List<Author> getAllAuthor() {
	    return authorDao.findAll();
	}
	
	//get
	@GetMapping("/author/{id}")
	public Optional<Author> getAuthorByID(@PathVariable Integer id) {
		return authorDao.findById(id);
	}
	// Create a new Note
	@PostMapping("/author")
	public Author createAuthor(@Valid @RequestBody Author author) {
	    return authorDao.save(author);
	}
	@DeleteMapping("/author/{id}")
	public void deleteAuthor(@PathVariable Integer id) {
		authorDao.deleteById(id);
	}
	@PutMapping("/author")
	public void updateAuthor(@Valid @RequestBody Author author) {
		authorDao.save(author);
	}
	
}
