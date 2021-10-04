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

@Service
public class CountryService {

	@Autowired
	private HibernateConfig hibernateConfig;
	private static List<Country> countries = new ArrayList<Country>();
	
	
	public CountryService(HibernateConfig hibernateConfig) {
		this.hibernateConfig = hibernateConfig;
	}
	
	
	@Transactional
	public void addCountry(Country country) {
		//this.countries.add(country);
		var session = hibernateConfig.getSession();
		// need to check transaction is active or not
		var tx = session.getTransaction();
		if(!tx.isActive())
			tx = session.beginTransaction();
		country.setId(countries.size() + 1);
		session.save(country);
		tx.commit();		
	}
	
	
	//searching from database
	public Country getCountryByCode(String countryCode) {
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
		CriteriaQuery<Country> cq = cb.createQuery(Country.class);
		Root<Country> root = cq.from(Country.class);
		cq.where(cb.equal(root.get("countryCode"), countryCode));
		var result = hibernateConfig.getSession()
				.getEntityManagerFactory()
				.createEntityManager()
				.createQuery(cq)
				.getResultList();

		// **************************** Criteria Query End **************************//
		return Optional.ofNullable(result.get(0))
				.orElse(null);
	}
	
	public List<Country> getCountry(){
		//return countries;
		// **************************** HQL Start ******************************//
//		 var session = hibernateConfig.getSession(); session.beginTransaction(); var
//		 query = session .getEntityManagerFactory() .createEntityManager().createQuery("SELECT c from com.spring5.practice.model.Country c ",
//		 Country.class);
//		 return query.getResultList();
		// **************************** HQL End ******************************//

		// **************************** Criteria Query Start
		// **************************//
		CriteriaBuilder cb = hibernateConfig.getCriteriaBuilder();
		CriteriaQuery<Country> cq = cb.createQuery(Country.class);
		Root<Country> root = cq.from(Country.class);
		cq.select(root);
		List<Country> countries = hibernateConfig.getSession()
				.getEntityManagerFactory()
				.createEntityManager()
				.createQuery(cq)
				.getResultList();

//		var countries = hibernateConfig.query(cq).getResultList();
		// **************************** Criteria Query End **************************//
		return countries;
	}

}
