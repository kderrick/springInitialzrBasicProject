package com.kyle.springframework.spring5webapp;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepo;
	private BookRepository bookRepo;

	public DevBootstrap(AuthorRepository authorRepo, BookRepository bookRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData() {
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Development", "1234", "Harper Collins");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepo.save(eric);
		bookRepo.save(ddd);
		

		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Dev without EJB", "12345", "Worx");
		rod.getBooks().add(noEJB);
		
		authorRepo.save(rod);
		bookRepo.save(noEJB);
	}

}
