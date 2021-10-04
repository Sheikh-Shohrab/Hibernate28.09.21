package com.shohrab.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shohrab.config.HibernateConfig;
import com.shohrab.models.Players;
import com.shohrab.models.User;

@Service
public class UserService {
	
	@Autowired
	private HibernateConfig hibernateConfig;
	
	private static List<User> users = new ArrayList<User>();
	
	
	@Transactional
	public void addUser(User user) {
		var session = hibernateConfig.getSession();
		var tx = session.getTransaction();
		if(!tx.isActive())
				tx = session.beginTransaction();
		user.setId(users.size()+1);
		session.save(user);
		session.flush();
		tx.commit();
	}
	
	public List<User> getUsers(){
		
		CriteriaBuilder cb = hibernateConfig.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root);
		
		List<User> users = hibernateConfig.getSession()
				.getEntityManagerFactory()
				.createEntityManager()
				.createQuery(cq)
				.getResultList();
		return users;
	}
}
