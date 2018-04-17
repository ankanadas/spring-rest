package com.springcore.spring_rest.repository;

import java.util.List;
import java.util.Optional;

import com.springcore.spring_rest.entity.Users;

public interface UserRepo {
	public List<Users> findAll();
	public Optional<Users> findOne(String id);
	public Optional<Users> findBy(String email);
	public Users create(Users user);
	public Users update( Users users);
	public void delete(Users user);
}
