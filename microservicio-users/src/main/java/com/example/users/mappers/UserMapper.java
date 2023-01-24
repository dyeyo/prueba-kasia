package com.example.users.mappers;

import org.springframework.stereotype.Component;

import com.example.users.dtos.UserDto;
import com.example.users.entites.UserEntity;

@Component
public class UserMapper {
	
	public UserDto userEntityToUserDto(UserEntity userEntity) {
		UserDto user = new UserDto();
		user.setId(userEntity.getId());
		user.setFirstName(userEntity.getFirstName());
		user.setLastName(userEntity.getLastName());
		user.setEmail(userEntity.getEmail());
		return user;
	}
	
	public UserEntity UserDtoTouserEntity(UserDto userDto) {
		UserEntity user = new UserEntity();
		user.setId(userDto.getId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		return user;
	}
}
