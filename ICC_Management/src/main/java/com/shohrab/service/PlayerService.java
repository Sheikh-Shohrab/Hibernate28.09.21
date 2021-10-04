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

@Service
public class PlayerService {
	
	@Autowired
	private HibernateConfig hibernateConfig;
	private static List<Players> players = new ArrayList<Players>();
	
	@Autowired
	private TeamService teamService;
	
	@Transactional
	public void addPlayer(Players player, int id) {
		var session = hibernateConfig.getSession();
		var tx = session.getTransaction();
		if(!tx.isActive())
				tx = session.beginTransaction();
		player.setId(players.size()+1);
		player.setTeam(teamService.getTeamById(id));
		session.save(player);
		session.flush();
		tx.commit();
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
