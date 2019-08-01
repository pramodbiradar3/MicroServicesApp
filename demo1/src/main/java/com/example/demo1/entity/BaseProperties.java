package com.example.demo1.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseProperties {
	
	@Column(name="CREATEDBY")
	private Integer createdBy;
	
	@Column(name="CREATEDON")
	private LocalDateTime createdOn;
	
	@Column(name="UPDATEDBY")
	private Integer updatedBy;
	
	@Column(name="UPDATEDON")
	private LocalDateTime updatedOn;
	
	@Column(name="ACTIVE")
	private String active;
}
