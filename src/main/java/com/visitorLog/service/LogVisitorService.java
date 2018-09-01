package com.visitorLog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visitorLog.entity.LogVisitor;
import com.visitorLog.repository.LogVisitorRepository;

@Service
public class LogVisitorService {
	
	@Autowired
	LogVisitorRepository logVisitorRepository;
	
	//save appointment
	public void save(LogVisitor log) {
		logVisitorRepository.save(log);
	}
	
	//delete appointment
	public void delete(int id) {
		logVisitorRepository.deleteById(id);
	}
	
	//update appointment
	public void update(LogVisitor v, int id) {
		LogVisitor log = logVisitorRepository.findById(id).orElse(new LogVisitor());
		
		log.setvId(v.getvId());
		log.seteId(v.geteId());
		log.setLogDate(v.getLogDate());
		log.setLogInTime(v.getLogInTime());
		log.setLogOutTime(v.getLogOutTime());
		log.setReason(v.getReason());
		
		logVisitorRepository.save(log);
	}
	
	//get appointment by id
	public LogVisitor getById(int id) {
		return logVisitorRepository.findById(id).orElse(new LogVisitor());
	}
	
	//get appointment by log date
	public List<LogVisitor> getAllAppointment() {
		return logVisitorRepository.ExpectedAppointment();
	}
	
	//get all
	public List<LogVisitor> getAll(){
		return logVisitorRepository.findAll();
	}

	//get logged in visitors only
	public List<LogVisitor> getLoggedIn(){
		return logVisitorRepository.findLoggedIn();
	}
	
	//get Logged out visitor only
	public List<LogVisitor> getLoggedOut(){
		return logVisitorRepository.findLoggedOut();
	}

}
