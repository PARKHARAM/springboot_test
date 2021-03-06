package com.example.demo.repo;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ExRepository {
	private final EntityManager em;

	public void saveUser(User user){
		em.persist(user);
	}

	public User findUserByEmail(String email){
		TypedQuery<User> query = em.createQuery("select m from User as m where m.email = ?1", User.class)
			.setParameter(1, email);
		return query.getSingleResult();
	}
}