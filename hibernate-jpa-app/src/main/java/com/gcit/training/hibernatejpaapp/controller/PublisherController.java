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

import com.gcit.training.hibernatejpaapp.dao.PublisherDao;
import com.gcit.training.hibernatejpaapp.entity.Publisher;
import com.gcit.training.hibernatejpaapp.entity.Publisher;

@RestController
@RequestMapping("/lms")
public class PublisherController {

	@Autowired
	private PublisherDao publisherDao;
	
	@GetMapping("/publisher")
	public List<Publisher> getAllPublisher() {
		return publisherDao.findAll();
	}
	@GetMapping("/publisher/{id}")
	public Optional<Publisher> getPublisherByID(@PathVariable Integer id) {
		return publisherDao.findById(id);
	}
	// Create a new Note
	@PostMapping("/publisher")
	public Publisher createPublisher(@Valid @RequestBody Publisher publisher) {
	    return publisherDao.save(publisher);
	}
	@DeleteMapping("/publisher/{id}")
	public void deletePublisher(@PathVariable Integer id) {
		publisherDao.deleteById(id);
	}
	@PutMapping("/publisher")
	public void updatePublisher(@Valid @RequestBody Publisher publisher) {
		publisherDao.save(publisher);
	}
}
