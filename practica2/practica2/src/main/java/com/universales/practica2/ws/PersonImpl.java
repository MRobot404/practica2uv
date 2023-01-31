package com.universales.practica2.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.universales.practica2.dto.Person;
import com.universales.practica2.repository.PersonRepository;
import com.universales.practica2.wsint.Personint;

@Component
public class PersonImpl  implements Personint{

	@Autowired
	PersonRepository personRepository;
	
	@Override
	public List<Person>buscarPerson(){
		return personRepository.findAll();
	}
}
