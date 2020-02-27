package com.adapter.dbadapter.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository
public class Dao{
	
	@Value("${query}") String query;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<String> getAll() {		
		List<String> results = entityManager.createNativeQuery("select CAST(row_to_json(row) as VARCHAR) from (" + query + ") row;").getResultList();
		return results;
	}	
}
