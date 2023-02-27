package com.example.spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.spring.mongo.api.model.Books;

public interface BookRepo extends MongoRepository< Books , Integer> {
	
	
}
