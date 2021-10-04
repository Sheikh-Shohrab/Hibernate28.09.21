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
import com.shohrab.models.Country;
import com.shohrab.models.Team;

@Service
public class TeamService {

	@Autowired
	private HibernateConfig hibernateConfig;
	@Autowired
	private CountryService countryService;
	
	private List<Team> teams = new ArrayList<Team>();

	public TeamService(HibernateConfig hibernateConfig) {
		this.hibernateConfig = hibernateConfig;
	}
	
	@Transactional
	public void addTeam(Team team, String countryCode) {
		var session = hibernateConfig.getSession();
		var tx = session.getTransaction();
		if(!tx.isActive())
				tx = session.beginTransaction();
		team.setId(teams.size()+1);
		team.setCountry(countryService.getCountryByCode(countryCode));
		session.save(team);
		session.flush();
		tx.commit();
	}
	
	
	public Team getTeamById(long id) {
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
		CriteriaQuery<Team> cq = cb.createQuery(Team.class);
		Root<Team> root = cq.from(Team.class);
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
	
	
	
	public List<Team> getTeam(){
		CriteriaBuilder cb = hibernateConfig.getCriteriaBuilder();
		CriteriaQuery<Team> cq = cb.createQuery(Team.class);
		Root<Team> root = cq.from(Team.class);
		cq.select(root);
		
		List<Team> teams = hibernateConfig.getSession()
				.getEntityManagerFactory()
				.createEntityManager()
				.createQuery(cq)
				.getResultList();
		
		return teams;
	}

}
