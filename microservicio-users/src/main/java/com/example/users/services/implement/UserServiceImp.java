package com.example.users.services.implement;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.users.dtos.UserDto;
import com.example.users.entites.Users;
import com.example.users.repositoris.UserRepository;
import com.example.users.services.UserServices;

@Service
public class UserServiceImp implements UserServices{
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	
	@Override
	public Page<Users> findAllPaginabe(Pageable page) {
		return repository.findAll(page);
	}

	@Override
	public Optional<Users> findByEmail(String email) {
		return repository.findByEmail(email);
	}


	@Override
	public Users save(Users user) {
		return repository.save(user);
	}

	
}
