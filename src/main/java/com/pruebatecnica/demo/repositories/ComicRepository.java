package com.pruebatecnica.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.demo.entity.ComicEntity;

@Repository
public interface ComicRepository extends CrudRepository<ComicEntity, String> {

}
