package com.universales.practica2.dto;

import java.io.*;
import jakarta.persistence.*;

@Entity
@Table(name="PERSON")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Campos de la base de datos
	@Id
	@Basic(optional = false)
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;

	//Getters and Setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
