package com.visitorLog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.visitorLog.entity.LogVisitor;

public interface LogVisitorRepository extends JpaRepository<LogVisitor, Integer> {

	@Query(value="Select * from LogVisitor where logOutTime is null and checkedIn = false", nativeQuery=true)
	public List<LogVisitor> ExpectedAppointment();
	
	@Query(value="Select L from LogVisitor L where L.logDate = curdate() and L.checkedIn = true")
	public List<LogVisitor> findLoggedIn();
	
	@Query(value="Select L from LogVisitor L where L.logDate = curdate() and L.checkedIn = true and L.logOutTime is not null")
	public List<LogVisitor> findLoggedOut();
}
