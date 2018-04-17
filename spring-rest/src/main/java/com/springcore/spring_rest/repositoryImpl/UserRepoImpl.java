package com.springcore.spring_rest.repositoryImpl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.springcore.spring_rest.entity.Users;
import com.springcore.spring_rest.repository.UserRepo;

@Repository
public class UserRepoImpl implements UserRepo{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Users> findAll() {
		TypedQuery<Users> query = em.createNamedQuery("Users.findAll", Users.class);
		return query.getResultList();
	}

	@Override
	public Optional<Users> findOne(String id) {;
		return Optional.ofNullable(em.find(Users.class,  id));
	}

	@Override
	public Users create(Users user) {
		em.persist(user);
		return user;
	}

	@Override
	public Users update( Users users) {
		return em.merge(users);
	}

	@Override
	public void delete(Users user) {
		em.remove(user);
		
	}

	@Override
	public Optional<Users> findBy(String email) {
		TypedQuery<Users> query = em.createNamedQuery("Users.findByEmail", Users.class);
		query.setParameter("emailID", email);
		List<Users> users = query.getResultList();
		if(!users.isEmpty()){
			return Optional.of(users.get(0));
		}
 		return Optional.empty();
	}

}
