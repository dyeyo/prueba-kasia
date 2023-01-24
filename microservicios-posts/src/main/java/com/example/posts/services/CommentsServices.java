package com.example.posts.services;

import com.example.posts.entities.Comment;


public interface CommentsServices {

	Comment findByid(Long id);
	Comment save(Comment post);
}
