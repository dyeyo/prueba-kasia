package com.example.posts.entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String body;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedaAt;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	@Column(name = "user_id")
	private Integer author;
	
	@PrePersist
	public void prePersist() {
		this.createdAt = new Date();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedaAt() {
		return updatedaAt;
	}

	public void setUpdatedaAt(Date updatedaAt) {
		this.updatedaAt = updatedaAt;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}
	
	
}
