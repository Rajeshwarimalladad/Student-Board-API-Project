package com.school.sba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.sba.requestdto.UserRequest;
import com.school.sba.responsedto.UserResponse;
import com.school.sba.service.UserService;
import com.school.sba.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/users/register")
	public ResponseEntity<ResponseStructure<UserResponse>> userRegistration(@RequestBody @Valid UserRequest userRequest){
		return userService.userRegistration(userRequest);
	}
	@GetMapping("users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable int userId){
		return userService.findUserById(userId);
	}
	@DeleteMapping("users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> deleteUserById(@PathVariable int userId){
		return userService.deleteUserById(userId);
	}
}
