package br.com.victorluiz.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.victorluiz.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person findById(String id) {
		logger.info("Finding one person!");
		return mockPerson(1);
	}
	
	public List<Person> findAll() {
		logger.info("Finding all people!");
		List<Person> persons = new ArrayList<>();
		for(int i = 0; i < 8; i++) {
			persons.add(mockPerson(i));
		}
		
		return persons;
	}
	
	public Person create(Person person) {
		logger.info("create one person!");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("create one person!");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting one person!");
	}
	
	private Person mockPerson(int i) {
		return new Person(counter.incrementAndGet(), "Victor", "Luiz", "Avenida Amazonas", "Male");
	}
}
