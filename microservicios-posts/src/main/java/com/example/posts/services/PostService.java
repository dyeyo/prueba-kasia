package com.example.posts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.posts.entities.Post;

public interface PostService {
	List<Post> getAllpost();
	Post save(Post post);
	Page<Post> findAllPaginable(Pageable page);
	Optional<Post> findByid(Long id);
	List<Post> getPostsByUser(Integer userId);
}