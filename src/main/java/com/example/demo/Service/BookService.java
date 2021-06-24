package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Model.Book;
import com.example.demo.dao.BookRepository;

@Component
public class BookService {

	@Autowired
	BookRepository bookRepository;
	//private static List<Book> list = new ArrayList<>();

	/*
	 * static {
	 * 
	 * list.add(new Book(2, "xyz", "bcd")); list.add(new Book(3, "pou", "mnp"));
	 * list.add(new Book(4, "jio", "zse")); list.add(new Book(5, "airtel", "cdf"));
	 * 
	 * }
	 */
	
	
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	public Book getBookbyId(int id) {
		Book book = null;
		//book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		book = this.bookRepository.findById(id);
		return book;
	}

	public Book addBook(Book b) {
		//list.add(b);
		Book book = this.bookRepository.save(b);
		return book;
	}

	public void deleteBook(int bookId) {

		//list = list.stream().filter(book -> book.getId() != bookId).collect(Collectors.toList());
		this.bookRepository.deleteById(bookId);
	}

	public void updateBook(Book book, int bookId) {

		/*
		 * list.stream().map(e -> { if (e.getId() == bookId) {
		 * e.setTitle(book.getTitle()); e.setAuthor(book.getAuthor());
		 * 
		 * }
		 * 
		 * return e; }).collect(Collectors.toList());
		 */

		book.setId(bookId);
		this.bookRepository.save(book);
		
	}

}
