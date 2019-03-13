package com.kyle.springframework.spring5webapp;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepo;
	private BookRepository bookRepo;
	private PublisherRepository publisherRepo;
	

	public DevBootstrap(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo = publisherRepo;
	}



	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
	}

	private void initData() {
		Publisher publisher = new Publisher();
		publisher.setName("Foo");
		publisher.setAddress("1234");
		
		publisherRepo.save(publisher);
		
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Development", "1234", publisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepo.save(eric);
		bookRepo.save(ddd);
		

		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Dev without EJB", "12345", publisher);
		rod.getBooks().add(noEJB);
		
		authorRepo.save(rod);
		bookRepo.save(noEJB);
	}

}
