package com.example.users.services.implement;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.users.dtos.UserDto;
import com.example.users.entites.UserEntity;
import com.example.users.mappers.UserMapper;
import com.example.users.repositoris.UserRepository;
import com.example.users.services.UserServices;
@Service
public class UserServiceImp implements UserServices{
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public Page<UserDto> findAllPaginabe(Pageable page) {
		
		
		Page<UserEntity> users = repository.findAll(page);
		
		Page<UserDto> dtoPage = users.map(new Function<UserEntity, UserDto>() {
		    @Override
		    public UserDto apply(UserEntity entity) {
		    	UserDto dto = new UserDto();
		    	return userMapper.userEntityToUserDto(entity);
		    }
		});
		
		return dtoPage;
	}

	@Override
	public Optional<UserEntity> findByEmail(String email) {
		return repository.findByEmail(email);
	}


	@Override
	public UserEntity save(UserEntity user) {
		return repository.save(user);
	}

	
}
