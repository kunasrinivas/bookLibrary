package com.kuna.booklibrary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuna.booklibrary.entity.Book;
import com.kuna.booklibrary.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/")
	public String home() {
		return "Welcome to Kuna Book Libary";
	}
	
	@PostMapping(value = "/save", consumes = "application/json")
	public List<Book> addBookJson(@RequestBody Book b) {
		bookService.save(b);
		return bookService.getAllBooks();
	}
	
	@PostMapping(value = "/save", consumes = "application/x-www-form-urlencoded")
	public List<Book> addBookForm(Book b) {
		bookService.save(b);
		return bookService.getAllBooks();
	}
	
	@GetMapping("/allBooks")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping("/findBook/{id}")
	public Optional<Book> getBookById (@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	@RequestMapping("/deleteBook/{id}") 
	public void deleteBook (@PathVariable("id") int id){
		bookService.deleteBookById(id);		
	}

}
