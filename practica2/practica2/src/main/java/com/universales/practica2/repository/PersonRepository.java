package com.universales.practica2.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universales.practica2.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Serializable>{

public Person findByUsernameAndPassword(String username, String password);
}
