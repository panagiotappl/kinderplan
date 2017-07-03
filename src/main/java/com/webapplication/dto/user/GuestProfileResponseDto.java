package com.webapplication.dto.user;

/**
 * Created by mary on 3/7/2017.
 */
public class GuestProfileResponseDto {
	private Integer id;
	private String name;
	private String surname;
	private String email;
	private GuestProfileProviderDto provider;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GuestProfileProviderDto getProvider() {
		return provider;
	}

	public void setProvider(GuestProfileProviderDto provider) {
		this.provider = provider;
	}
}
