package com.pruebatecnica.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.demo.entity.CharacterEntity;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterEntity, String> {

	@Query(value="select c.* from character c where c.name = :name", nativeQuery=true)
	CharacterEntity findByName(String name);

}
