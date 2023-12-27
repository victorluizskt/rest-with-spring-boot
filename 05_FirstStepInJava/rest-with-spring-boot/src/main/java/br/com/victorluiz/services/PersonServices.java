package br.com.victorluiz.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorluiz.exceptions.ResourceNotFoundException;
import br.com.victorluiz.model.Person;
import br.com.victorluiz.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public Person findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}
	
	public Person create(Person person) {
		logger.info("create one person!");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("create one person!");
		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		var newPerson = new Person(entity);
		return repository.save(newPerson);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
}
