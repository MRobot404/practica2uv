package com.universales.practica2.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;


import com.universales.practica2.dto.Person;

public interface PersonService {
	public void savePerson(Person person);
	public Person getPersonByUsernameAndPassword(String username,String password)  throws UserPrincipalNotFoundException;
}
