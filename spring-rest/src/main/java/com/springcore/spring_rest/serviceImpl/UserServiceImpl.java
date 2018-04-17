package com.springcore.spring_rest.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcore.spring_rest.entity.Users;
import com.springcore.spring_rest.exception.BadException;
import com.springcore.spring_rest.exception.NotFoundException;
import com.springcore.spring_rest.repository.UserRepo;
import com.springcore.spring_rest.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	UserRepo repository;
	
	public UserServiceImpl(UserRepo repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Users> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Users findOne(String id) {
		return repository.findOne(id).orElseThrow(()->
						new NotFoundException("user with "+id+" does not exist"));
	}

	@Override
	@Transactional
	public Users create(Users user) {
		Optional<Users> mayexist= repository.findBy(user.getEmail());
		if(mayexist.isPresent()){
			throw new BadException("user with email "+user.getEmail()+" already exists!");
		}
		return repository.create(user);
	}

	@Override
	@Transactional
	public Users update(String id, Users users) {
		repository.findOne(id).orElseThrow(()->
						new NotFoundException("user with "+id+" does not exist"));
		return repository.update(users);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Users existing = repository.findOne(id).orElseThrow(()->
							new NotFoundException("user with "+id+" does not exist"));
		repository.delete(existing);
		
	}

}
