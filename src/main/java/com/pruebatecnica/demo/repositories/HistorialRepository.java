package com.pruebatecnica.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.demo.entity.HistorialEntity;

@Repository
public interface HistorialRepository extends JpaRepository<HistorialEntity, String> {

	@Query(value="select h.* from historial h where h.username = :username", nativeQuery=true)
	List<HistorialEntity> findByUsername(String username);
	
	@Query(value="select h.* FROM historial h where lower(h.search_type) like '%historieta%' and h.username = :username", nativeQuery=true)
	List<HistorialEntity> findLikeHistorieta(String username);
}
