package com.kuna.booklibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuna.booklibrary.entity.Book;
import com.kuna.booklibrary.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepo;
	
	public void save(Book b) {
		bookRepo.save(b);
	}
	
	public Optional<Book> getBookById(int id) {
		return bookRepo.findById(id);
	}
	
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	public void deleteBookById (int id) {
		bookRepo.deleteById(id);
	}
	
	public void deleteAllBooks() {
		bookRepo.deleteAll();
	}
}
