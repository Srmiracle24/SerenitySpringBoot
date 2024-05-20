package com.miracle.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miracle.modelo.Embedding;

@Repository
public interface IRepository extends JpaRepository<Embedding, Integer> {
	
	

}