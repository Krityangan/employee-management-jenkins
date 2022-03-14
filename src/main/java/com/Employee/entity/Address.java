package com.Employee.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "Address_detail")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonProperty("line1")
	@Column(name = "line1")
	private String line1;
	
	@JsonProperty("line2")
	@Column(name = "line2")
	private String line2;
	
	@JsonProperty("line3")
	@Column(name = "line3")
	private String line3;
	
	@JsonProperty("pincode")
	@Column(name = "pincode")
	private String pincode;
	
	@JsonProperty("type")
	@Column(name = "type")
	private String type;
	
	@JsonProperty("state")
	@Column(name = "state")
	private String state;
	
	@JsonProperty("district")
	@Column(name = "district")
	private String district;
	
	@JsonProperty("country")
	@Column(name = "country")
	private String country;
	
	@JsonProperty("landmark")
	@Column(name = "landmark")
	private String landmark;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JsonIgnore
//	private Employee employee;
}
