package com.example.spring.mongo.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.example.spring.mongo.api.model.Books;
import com.example.spring.mongo.api.repository.BookRepo;

@RestController
public class BooksController {

	@Autowired
	private BookRepo repository;
	
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Books book) {
		repository.save(book);
		return "Added book of id : " +book.getId();
	}
	
	@PutMapping("/update")
	 //@ResponseStatus(OK)
	public String updateBook(@RequestBody Books book) {
		repository.save(book);
		return "Updated book of id : "+book.getId();
	}
	
	@GetMapping("/findAllBooks")
	public List<Books> getBooks(){
		return repository.findAll();		
	}
	
	@GetMapping("/findBooks/{id}")
	public Optional<Books> getBooks(@PathVariable int id){
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "Book is deleted with id : " +id ;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("swagger-ui.html")
	      .addResourceLocations("classpath:/META-INF/resources/");

	    registry.addResourceHandler("/webjars/**")
	      .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	
}
