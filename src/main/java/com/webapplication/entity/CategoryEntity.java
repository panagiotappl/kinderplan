package com.webapplication.entity;


/**
 * Created by mary on 3/6/2017.
 */

import javax.persistence.*;

@Entity
@Table(
		name="Categories",
		uniqueConstraints=
		@UniqueConstraint(columnNames={"category"})
)
public class CategoryEntity {

	@Id
	@SequenceGenerator(name = "categories_id_seq",
			sequenceName = "categories_id_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
			generator = "categories_id_seq")
	@Column(name = "id", nullable = false)
	private Integer id;
	private String category;

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
}
