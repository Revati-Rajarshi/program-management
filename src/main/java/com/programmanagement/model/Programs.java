package com.programmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;;



/**
 * 
 * Class representing an Entity mapped to a database table "programs"
 *
 */
@Entity
@Table(name = "programs")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt","updatedAt"}, allowGetters = true)
public class Programs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private Long pid;
	
	@Column(name = "name") 
	@JsonProperty("name")
	@NotNull(message="Program name cannot be null")
	private String pname;
	
	@Column(name = "detials") 
	@JsonProperty("details")
	@NotNull(message="Program details cannot be null")
	private String details;
	
	@Column(name = "status") 
	@JsonProperty("status")
	@NotNull(message="Program status cannot be null")
	private Boolean active;
	

	@JsonProperty("createdAt")
	@Column(name = "createdAt", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
 
	@JsonProperty("updatedAt")
	@Column(name = "updatedAt", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public Programs() {}
	public Programs(@NotNull(message = "Program name cannot be null") String pname,
			@NotNull(message = "Program details cannot be null") String details,
			@NotNull(message = "Program status cannot be null") Boolean active) {
		super();
		this.pname = pname;
		this.details = details;
		this.active = active;
	}


	public Long getPid() {
		return pid;
	}


	public void setPid(Long pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	


	
	

}
