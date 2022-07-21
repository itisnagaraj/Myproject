package com.sarvesh.model;

public class CountryInfo {
	private String country_code;
	private String iso_code;
	private String name;
	private String name_in_own_language;
	private String population;
	private String capital;
	private String currency;
	private String pMPre;
	private String pmpresident;
	private String continent;
	public CountryInfo(String country_code, String iso_code, String name, String name_in_own_language, String population, String capital,String currency, String pMPre, String pmpresident, String continent) {
this.country_code = country_code;
this.iso_code = iso_code;
this.name = name;
this.name_in_own_language = name_in_own_language;
this. population =  population;
this.capital = capital;
this.currency = currency;
this. pMPre =  pMPre;
this.pmpresident = pmpresident;
this.continent = continent;
}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getIso_code() {
		return iso_code;
	}
	public void setIso_code(String iso_code) {
		this.iso_code = iso_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName_in_own_language() {
		return name_in_own_language;
	}
	public void setName_in_own_language(String name_in_own_language) {
		this.name_in_own_language = name_in_own_language;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getpMPre() {
		return pMPre;
	}
	public void setpMPre(String pMPre) {
		this.pMPre = pMPre;
	}
	public String getPmpresident() {
		return pmpresident;
	}
	public void setPmpresident(String pmpresident) {
		this.pmpresident = pmpresident;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	@Override
	public String toString() {
		return "CountryInfo [country_code=" + country_code + ", iso_code=" +iso_code + ", name=" + name +", name_in_own_language=" + name_in_own_language + ", population=" + population + ", capital=" + capital +", currnecy=" + currency +", PMPre=" + pMPre +", pmpresident="+ pmpresident +", continent= "+ continent +"]"; 
	}
}
