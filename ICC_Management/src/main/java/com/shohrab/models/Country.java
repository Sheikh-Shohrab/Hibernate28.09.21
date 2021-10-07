package com.shohrab.models;

import javax.persistence.Column;



import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="country_tbl")
public class Country extends BaseModel{

	
	@Column(name = "country_code", unique = true, nullable = false, updatable = false)
	private String countryCode;
	
	@Column(name="country_name", nullable = false)
	private String countryName;
	
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Country(String countryCode, String countryName) {
		super();
		
		this.countryCode = countryCode;
		this.countryName = countryName;
	}


	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	@Override
	public String toString() {
		return "Country [countryCode=" + countryCode + ", countryName=" + countryName + "]";
	}

}
