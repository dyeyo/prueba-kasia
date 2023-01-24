package com.example.posts.services.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.posts.entities.Comment;
import com.example.posts.repositoris.CommentsRepository;
import com.example.posts.services.CommentsServices;

@Service
public class CommentsServicesImpl implements CommentsServices {

	@Autowired
	private CommentsRepository repo;
	
	@Override
	public Comment save(Comment comment) {
		return repo.save(comment);
	}

	@Override
	public Comment findByid(Long id) {
		Optional<Comment> commentExist = repo.findById(id);
		if(commentExist.isPresent()) {
			return commentExist.get();
		}
		return null;
	}

}
