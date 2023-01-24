package com.example.posts.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.posts.entities.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Long> {

}
