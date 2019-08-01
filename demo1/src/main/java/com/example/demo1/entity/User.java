package com.example.demo1.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USERID")
	private Integer userId;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="LOGINNAME")
	private String loginName;
	
	@Column(name="PASSWORD")
	private String password;
	
	public User(String loginName,String userName,String password) {
		this.loginName=loginName;
		this.userName=userName;
		this.password=password;
	}
	
	@Embedded
	private BaseProperties baseProperties;
}
