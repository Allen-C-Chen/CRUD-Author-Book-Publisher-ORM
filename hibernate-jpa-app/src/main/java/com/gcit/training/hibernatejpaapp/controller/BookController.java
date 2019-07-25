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

import com.gcit.training.hibernatejpaapp.dao.BookDao;
import com.gcit.training.hibernatejpaapp.entity.Book;

@RestController
@RequestMapping("/lms")
public class BookController {
	@Autowired
	private BookDao bookDao;
	@GetMapping("/book")
	public List<Book> getAllBook() {
		return bookDao.findAll();
	}
	@GetMapping("/book/{id}")
	public Optional<Book> getBookByID(@PathVariable Integer id) {
		return bookDao.findById(id);
	}
	// Create a new Note
	@PostMapping("/book")
	public Book createBook(@Valid @RequestBody Book book) {
	    return bookDao.save(book);
	}
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable Integer id) {
		bookDao.deleteById(id);
	}
	@PutMapping("/book")
	public void updateBook(@Valid @RequestBody Book book) {
		bookDao.save(book);
	}
	
}
