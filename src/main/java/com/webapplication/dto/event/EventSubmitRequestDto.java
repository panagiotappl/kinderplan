package com.webapplication.dto.event;

import com.webapplication.dto.CategoryDto;

import java.sql.Timestamp;
import java.util.HashSet;

/**
 * Created by mary on 11/6/2017.
 */
public class EventSubmitRequestDto {
	private Integer id;
	private String name;
	private Integer provider;
	private String address;
	private Float longitude;
	private Float latitude;
	private Integer age_from;
	private Integer age_to;
	private Integer ticket_price;
	private String description;
	private Timestamp date_ending;
	private Timestamp date_starting;
	private HashSet<CategoryDto> categories;
	private HashSet<EventDateSubmitRequestDto> dates;
	//private HashSet<String> photos;

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

	public Integer getProvider() {
		return provider;
	}

	public void setProvider(Integer provider) {
		this.provider = provider;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Integer getAge_from() {
		return age_from;
	}

	public void setAge_from(Integer age_from) {
		this.age_from = age_from;
	}

	public Integer getAge_to() {
		return age_to;
	}

	public void setAge_to(Integer age_to) {
		this.age_to = age_to;
	}

	public Integer getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(Integer ticket_price) {
		this.ticket_price = ticket_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Timestamp getDate_ending() {
		return date_ending;
	}

	public void setDate_ending(Timestamp date_ending) {
		this.date_ending = date_ending;
	}

	public Timestamp getDate_starting() {
		return date_starting;
	}

	public void setDate_starting(Timestamp date_starting) {
		this.date_starting = date_starting;
	}

	public HashSet<EventDateSubmitRequestDto> getDates() {
		return dates;
	}

	public void setDates(HashSet<EventDateSubmitRequestDto> dates) {
		this.dates = dates;
	}

	public HashSet<CategoryDto> getCategories() {
		return categories;
	}

	public void setCategories(HashSet<CategoryDto> categories) {
		this.categories = categories;
	}

	//	public HashSet<String> getPhotos() {
//		return photos;
//	}

//	public void setPhotos(HashSet<String> photos) {
//		this.photos = photos;
//	}
}
