package com.example.users.repositoris;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.users.dtos.UserDto;
import com.example.users.entites.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	public Optional<UserEntity> findByEmail(String email);
}
