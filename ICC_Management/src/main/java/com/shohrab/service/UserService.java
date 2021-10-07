package com.shohrab.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shohrab.config.HibernateConfig;

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
	
	public User getUserById(long id) {
		// **************************** HQL Start ******************************//
//		var session = hibernateConfig.getSession();
//		var transaction = session.beginTransaction();
//		var query = session
//				.getEntityManagerFactory()
//				.createEntityManager()
//				.createQuery("SELECT c from com.spring5.practice.model.Country c where c.countryCode=:countryCode", Country.class);
//		query.setParameter("countryCode", countryCode);
		// **************************** HQL End ******************************//

		// **************************** Criteria Query Start
		// **************************//
		CriteriaBuilder cb = hibernateConfig.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.where(cb.equal(root.get("id"), id));
		var result = hibernateConfig.getSession()
				.getEntityManagerFactory()
				.createEntityManager()
				.createQuery(cq)
				.getResultList();

		// **************************** Criteria Query End **************************//
		return Optional.ofNullable(result.get(0))
				.orElse(null);
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
