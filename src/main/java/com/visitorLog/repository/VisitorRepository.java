package com.visitorLog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.visitorLog.entity.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Integer> {

	@Query(value="Select * from Visitor "
			+ "where firstName like %?1% or "
			+ "lastName like %?1% or "
			+ "email like %?1% or "
			+ "phone like %?1%", nativeQuery=true)
	public List<Visitor> search(String value);
	
	public Visitor findByvId(int id);

	
}
