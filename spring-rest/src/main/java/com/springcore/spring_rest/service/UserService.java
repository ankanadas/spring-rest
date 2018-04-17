package com.springcore.spring_rest.service;

import java.util.List;

import com.springcore.spring_rest.entity.Users;

public interface UserService {
	public List<Users> findAll();
	public Users findOne(String id);
	public Users create(Users user);
	public Users update(String id, Users users);
	public void delete(String id);
}
