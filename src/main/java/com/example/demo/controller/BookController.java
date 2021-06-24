package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Book;
import com.example.demo.Service.BookService;

@RestController
//@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	// @RequestMapping(value="/books",method = RequestMethod.GET)
	@GetMapping("/books")
	public List<Book> getBooks() {

		return this.bookService.getAllBooks();

	}

	@GetMapping("/books/{id}")
	public Book getBookbyId(@PathVariable("id") int bookId) {

		return this.bookService.getBookbyId(bookId);

	}

	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return this.bookService.addBook(book);

	}
	
	@DeleteMapping("/books/{id}")
	public String deleteMapping(@PathVariable("id") int bookId)
	{
		this.bookService.deleteBook(bookId);
		return "Deleted";
	}
	
	
	@PutMapping("/books/{id}")
	public Book updateMapping(@RequestBody Book book, @PathVariable("id") int bookId)
	{
		this.bookService.updateBook(book,bookId);
		return book;
	}
	

}
