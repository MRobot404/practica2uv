package com.universales.practica2.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import com.universales.practica2.dto.Person;

public interface PersonService {
	 /**
     * Método que guarda un objeto Person en una ubicación persistente
     * @param person objeto a guardar
     */
	public void savePerson(Person person);	
	  /**
     * Método que devuelve un objeto Person asociado con un nombre de usuario y contraseña específicos
     * @param username nombre de usuario
     * @param password contraseña
     * @return objeto Person asociado con el nombre de usuario y la contraseña proporcionados
     * @throws UserPrincipalNotFoundException si no se encuentra un usuario con ese nombre de usuario y contraseña
     */
	public Person getPersonByUsernameAndPassword(String username,String password)  throws UserPrincipalNotFoundException;
	public List<Person> getAllPersons();
}
