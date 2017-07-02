package com.webapplication.dto.user;

/**
 * Created by mary on 2/7/2017.
 */
public class ProviderViewEventDto {
	private Integer id;
	private Integer vatNumber;
	private String companyName;
	private Integer user_id;
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(Integer vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
