package com.springcore.spring_rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcore.spring_rest.constants.URI;
import com.springcore.spring_rest.entity.Users;
import com.springcore.spring_rest.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value=URI.Users)
@Api(tags="users")
public  class UserController {
	
	public UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}

	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value="Find All Users" , notes="Returns a list of existing users")
	@ApiResponses({
		@ApiResponse(code=200, message="Success!!"),
		@ApiResponse(code=500, message="Internal Server Error")
	})
	public List<Users> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value=URI.ID)
	@ApiOperation(value="Find User using ID" , notes="Returns a particular")
	@ApiResponses({
		@ApiResponse(code=200, message="Success!!"),
		@ApiResponse(code=404, message="Not Found"),
		@ApiResponse(code=500, message="Internal Server Error")
	})
	public Users findOne(@PathVariable("id") String userId){
		return service.findOne(userId);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ApiResponses({
		@ApiResponse(code=200, message="Success!!"),
		@ApiResponse(code=400, message="Bad Request"),
		@ApiResponse(code=500, message="Internal Server Error")
	})
	public Users create(@RequestBody Users user){
		return service.create(user);
	}
	
	@ApiResponses({
		@ApiResponse(code=200, message="Success!!"),
		@ApiResponse(code=404, message="Not Found"),
		@ApiResponse(code=500, message="Internal Server Error")
	})
	@RequestMapping(method=RequestMethod.PUT, value=URI.ID)
	public Users update(@PathVariable("id") String id, @RequestBody Users users){
		return service.update(id, users);
	}
	
	@ApiResponses({
		@ApiResponse(code=200, message="Success!!"),
		@ApiResponse(code=404, message="Not Found"),
		@ApiResponse(code=500, message="Internal Server Error")
	})
	@RequestMapping(method=RequestMethod.DELETE, value=URI.ID)
	public void delete(@PathVariable("id") String id){
		service.delete(id);
	}
}
