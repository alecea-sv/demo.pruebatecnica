package com.pruebatecnica.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.demo.entity.ComicCharacterEntity;
import com.pruebatecnica.demo.entity.compositekey.ComicCharacterId;

@Repository
public interface ComicCharacterRepository extends JpaRepository<ComicCharacterEntity, ComicCharacterId> {
	
//	List<ComicCharacterEntity> findByComicId(String comicId);
//    List<ComicCharacterEntity> findByCharacterId(String characterId);
    
}
