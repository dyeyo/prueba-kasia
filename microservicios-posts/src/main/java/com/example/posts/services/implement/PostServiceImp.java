package com.example.posts.services.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.posts.entities.Post;
import com.example.posts.repositoris.PostRepository;

import com.example.posts.services.PostService;

@Service
public class PostServiceImp implements PostService {

	@Autowired
	private PostRepository repo;
	
	@Override
	public List<Post> getAllpost() {
		return repo.findAll();
	}

	@Override
	public Page<Post> findAllPaginable(Pageable page) {
		return repo.findAll(page);
	}
	
	@Override
	public Post save(Post post) {
		return repo.save(post);
	}

	@Override
	public Optional<Post> findByid(Long id) {
		return repo.findById(id);
	}

	@Override
	public List<Post> getPostsByUser(Integer userId) {
		return repo.findPostsByUserId(userId);
	}


}
