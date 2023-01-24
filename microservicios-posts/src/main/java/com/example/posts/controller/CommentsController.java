package com.example.posts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.posts.entities.Comment;
import com.example.posts.services.CommentsServices;

@RestController
public class CommentsController {

	@Autowired
	private CommentsServices commentService;
	
	
	@GetMapping("/comment/{id}")
	public Comment getById(@PathVariable("id") Long id) {
		return commentService.findByid(id);
	}

	
	@PostMapping("/comment/save")
	public ResponseEntity<Comment> save(@RequestBody Comment comment) {
		Comment newComment = commentService.save(comment);
		return ResponseEntity.status(HttpStatus.CREATED).body(newComment);
	}
}
