package com.universales.practica2.wsint;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.rmi.StubNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.universales.practica2.Service.PersonService;
import com.universales.practica2.dto.Person;
import com.universales.practica2.security.JwtGeneratorInterface;

@RestController
@RequestMapping("/api/noauth/")
@CrossOrigin
public class Personint {

	private PersonService personService;

private JwtGeneratorInterface jwtGenerator;


	@Autowired
	public Personint(PersonService personService, JwtGeneratorInterface jwtGenerator){
	    this.personService=personService;
	    this.jwtGenerator=jwtGenerator;
	  }
	
	 @PostMapping("/register")
	  public ResponseEntity<?> postUser(@RequestBody Person person){
	  try{
	     personService.savePerson(person);
	     return new ResponseEntity<>(person, HttpStatus.CREATED);
	   } catch (Exception e){
	     return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	   }
	  }
	 
	 @PostMapping("/login")
	  public ResponseEntity<?> loginUser(@RequestBody Person person) {
	    try {
	      if(person.getUsername() == null || person.getPassword() == null) {
	      throw new UserPrincipalNotFoundException("Usuario o contraseña vacio");
	    }
	    Person userData = personService.getPersonByUsernameAndPassword(person.getUsername(), person.getPassword());
	    if(userData == null){
	       throw new UserPrincipalNotFoundException("Usuario o contraseña incorrectos");
	    }
	       return new ResponseEntity<>(jwtGenerator.generateToken(person), HttpStatus.OK);
	    } catch (UserPrincipalNotFoundException e) {
	       return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
	    }
	  }
	 
	 
	 
	 @GetMapping("/buscar")
	 public ResponseEntity<List<Person>> getAllPersons() {
	     List<Person> persons = personService.getAllPersons();
	     return new ResponseEntity<>(persons, HttpStatus.OK);
	 }
	

}
