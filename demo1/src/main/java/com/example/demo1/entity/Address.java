package com.example.demo1.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADDRESSID")
	private Integer addressId;
	
	@Column(name="ADDRESS1")
	private String address1;
	
	@Column(name="ADDRESS2")
	private String address2;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="ZIP")
	private String zip;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="EMPLOYEEID")
	private Employee employee;
	
	@Embedded
	private BaseProperties baseProperties;

}
