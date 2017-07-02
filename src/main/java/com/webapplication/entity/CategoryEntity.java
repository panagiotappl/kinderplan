package com.webapplication.entity;


/**
 * Created by mary on 3/6/2017.
 */

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
		name="categories",
		uniqueConstraints=
		@UniqueConstraint(columnNames={"category"})
)
public class CategoryEntity {

	@Id
	@SequenceGenerator(name = "categories_id_seq",
			sequenceName = "categories_id_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,
			generator = "categories_id_seq")
	@Column(name = "id", nullable = false)
	private Integer id;
	private String category;
	@ManyToMany(mappedBy="categories")
	private Set<EventEntity> events = new HashSet<EventEntity>(0);

	public CategoryEntity(){
	}

	public CategoryEntity(String category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<EventEntity> getEvents() {
		return events;
	}

	public void setEvents(Set<EventEntity> events) {
		this.events = events;
	}
}
