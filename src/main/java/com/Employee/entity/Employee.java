package com.Employee.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee_Details")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@JsonProperty("f_name")
	@Column(name = "emp_firstname")
	private String firstName;
	
	@NotNull
	@JsonProperty("l_name")
	@Column(name = "emp_lastname")
	private String lastName;
	
	@JsonProperty("m_name")
	@Column(name = "emp_middlename")
	private String middleName;
	
	@JsonProperty("email")
	@NotNull(message = "Email is Required")
	@Column(name = "emp_email")
	private String email;
	
	@JsonProperty("address")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private List<Address> address;
	
	@JsonProperty("contact")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Contact> contact;
	
	
	@JsonProperty("dob")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dob;

	
}
