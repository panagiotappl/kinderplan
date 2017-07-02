package com.webapplication.entity;

/**
 * Created by mary on 3/6/2017.
 */

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(
		name="provider_comments"
)
public class CommentProviderEntity {
	@Id
	@SequenceGenerator(name = "commentProvider_id_seq",
			sequenceName = "commentProvider_id_seq",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY,
			generator = "commentProvider_id_seq")
	@Column(name = "id", nullable = false)
	private Integer id;
	private String comment;
	@ManyToOne
	private ProviderEntity provider;
	private Timestamp date;
	@ManyToOne
	private ParentEntity parent;

	public CommentProviderEntity() {
	}

	public CommentProviderEntity(String comment, ProviderEntity provider, Timestamp date, ParentEntity parent) {
		this.comment = comment;
		this.provider = provider;
		this.date = date;
		this.parent = parent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public ProviderEntity getProvider() {
		return provider;
	}

	public void setProvider(ProviderEntity provider) {
		this.provider = provider;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public ParentEntity getParent() {
		return parent;
	}

	public void setParent(ParentEntity user_id) {
		this.parent = user_id;
	}
}
