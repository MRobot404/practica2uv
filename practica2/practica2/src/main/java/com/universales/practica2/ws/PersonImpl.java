package com.universales.practica2.ws;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.universales.practica2.Service.PersonService;
import com.universales.practica2.dto.Person;
import com.universales.practica2.repository.PersonRepository;
import com.universales.practica2.wsint.Personint;

@Service
public class PersonImpl  implements PersonService {

	private PersonRepository personRepository;
	
	@Autowired
	  public PersonImpl(PersonRepository personRepository){
	    this.personRepository=personRepository;
	  }
	
	@Override
	  public void savePerson(Person person) {
	    personRepository.save(person);
	  }
	
	@Override
	  public Person getPersonByUsernameAndPassword(String username, String password) throws UserPrincipalNotFoundException {
	    Person user = personRepository.findByUsernameAndPassword(username, password);
	    if(user == null){
	       throw new UserPrincipalNotFoundException("Usuario o password invalido");
	    }
	    return user;
	  }

	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}
	
}
