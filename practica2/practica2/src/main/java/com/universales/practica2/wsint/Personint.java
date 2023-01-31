package com.universales.practica2.wsint;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.universales.practica2.dto.Person;

@RestController
@RequestMapping("/person")
@CrossOrigin
public interface Personint {

	@GetMapping("/buscar")
	public List<Person>buscarPerson();
	

}
