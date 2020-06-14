package com.ap.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ap.entity.Canvas;

@Repository

public interface CanvasRepository extends CrudRepository<Canvas, Long> {

	
	    Optional<Canvas> findById(Long id);
	    Iterable<Canvas> findAll();
	    Optional<Canvas> findByName(String name);
	    Optional<Canvas> findByParentId(Long parentId);
}
