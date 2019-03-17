package com.kyle.springframework.spring5webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	
	private BookRepository bookRepo;
	
	public BookController(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", bookRepo.findAll());
		return "books";
		
	}


}
