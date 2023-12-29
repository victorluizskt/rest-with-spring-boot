package br.com.victorluiz.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorluiz.data.vo.v1.PersonVO;
import br.com.victorluiz.data.vo.v2.PersonVO2;
import br.com.victorluiz.exceptions.ResourceNotFoundException;
import br.com.victorluiz.mapper.DozerMapper;
import br.com.victorluiz.mapper.custom.PersonMapper;
import br.com.victorluiz.model.Person;
import br.com.victorluiz.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	public PersonVO findById(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public List<PersonVO> findAll() {
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO create(PersonVO person) {
		logger.info("create one person!");
		var entity = DozerMapper.parseObject(person, Person.class);
		return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
	}
	
	public PersonVO2 createV2(PersonVO2 person) {
		logger.info("create one person!");
		var entity = mapper.convertVoToEntity(person);
		return mapper.convertEntityToVo(repository.save(entity));
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("create one person!");
		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		var newPerson = new Person(entity);
		return DozerMapper.parseObject(repository.save(newPerson), PersonVO.class);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}
}
