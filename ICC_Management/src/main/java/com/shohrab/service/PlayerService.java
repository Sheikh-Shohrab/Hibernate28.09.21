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
import com.shohrab.models.Players;

@Service
public class PlayerService {
	
	@Autowired
	private HibernateConfig hibernateConfig;
	private static List<Players> players = new ArrayList<Players>();
	
	@Autowired
	private TeamService teamService;

	@Autowired
	private UserService userService;
	
	@Transactional
	public void addPlayer(Players player, int id, int uid) {
		var session = hibernateConfig.getSession();
		var tx = session.getTransaction();
		if(!tx.isActive())
				tx = session.beginTransaction();
		player.setId(players.size()+1);
		player.setTeam(teamService.getTeamById(id));
		System.out.println("user id = "+userService.getUserById(uid));
		player.setUser(userService.getUserById(uid));
		session.save(player);
		session.flush();
		tx.commit();
	}
	
	public Players getPlayerById(long id) {
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
		CriteriaQuery<Players> cq = cb.createQuery(Players.class);
		Root<Players> root = cq.from(Players.class);
		cq.where(cb.equal(root.get("uid"), id));
		var result = hibernateConfig.getSession()
				.getEntityManagerFactory()
				.createEntityManager()
				.createQuery(cq)
				.getResultList();

		// **************************** Criteria Query End **************************//
		return Optional.ofNullable(result.get(0))
				.orElse(null);
	}
	
	
	public List<Players> getPlayer(){
		
		CriteriaBuilder cb = hibernateConfig.getCriteriaBuilder();
		CriteriaQuery<Players> cq = cb.createQuery(Players.class);
		Root<Players> root = cq.from(Players.class);
		cq.select(root);
		
		List<Players> players = hibernateConfig.getSession()
				.getEntityManagerFactory()
				.createEntityManager()
				.createQuery(cq)
				.getResultList();

		return players;
	}

}
