package br.com.victorluiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.victorluiz.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
