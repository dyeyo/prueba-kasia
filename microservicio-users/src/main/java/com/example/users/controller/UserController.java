package com.example.users.controller;

import java.util.Optional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.users.dtos.UserDto;
import com.example.users.entites.UserEntity;
import com.example.users.services.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices userService;

	@Value("${config.balanceador.test}")
	private String balanceadorTest;
	
	@GetMapping("/balanceador-test")
	public ResponseEntity<?> balanceadorTest() {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("balanceador", balanceadorTest);
		response.put("users", userService.findAll());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAll() {
		return ResponseEntity.ok().body(userService.findAll());
	}
	
	@GetMapping("/page/{page}")
	public Page<UserDto> getAllPagenable(@PathVariable Integer page) {
		return userService.findAllPaginabe(PageRequest.of(page, 10));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> findByEmail(@PathVariable("email") String email) {
		
		Optional<UserEntity> user = userService.findByEmail(email); 
		if (user.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user.get());
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@RequestBody UserEntity user) {
		
		Optional<UserEntity> emailExist = userService.findByEmail(user.getEmail());
		Map<String, Object>  response = new HashMap<>();
		if (emailExist.isPresent()) {
			response.put("mensage", "Email exist in database");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		} 
		UserEntity newUser= userService.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}
	
	
}
