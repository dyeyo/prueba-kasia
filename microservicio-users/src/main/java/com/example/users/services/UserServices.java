package com.example.users.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.users.dtos.UserDto;
import com.example.users.entites.Users;


public interface UserServices  {

	public List<Users> findAll();
	public Page<Users> findAllPaginabe(Pageable page);
	public Optional<Users> findByEmail(String email); 
	public Users save(Users user); 

}
