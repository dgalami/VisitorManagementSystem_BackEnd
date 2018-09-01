package com.visitorLog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visitorLog.entity.Visitor;
import com.visitorLog.repository.VisitorRepository;

@Service
public class VisitorService {

	@Autowired
	VisitorRepository visitorRepository;
	
	/*add new Visitor*/
	public Visitor addNewVisitor(Visitor visitor) {
		return visitorRepository.save(visitor);
	}
	
	/*get all visitors*/
	public List<Visitor> getAllVisitor(){
		return visitorRepository.findAll();
	}
	
	/*search Visitor*/
	public List<Visitor> search(String value){
		return visitorRepository.search(value);
	}
	
	//get visitor by id
	public Visitor findVisitorById(int id) {
		return visitorRepository.findByvId(id);
	}
	
	//delete visitor
	public void delete(int id) {
		visitorRepository.deleteById(id);
	}
	
	//update visitor info
	public void update(int id, Visitor visitor) {
		Visitor v = visitorRepository.findById(id).orElse(new Visitor());
		v.setFirstName(visitor.getFirstName());
		v.setLastName(visitor.getLastName());
		v.setPhone(visitor.getPhone());
		v.setEmail(visitor.getEmail());
		v.setCompany(visitor.getCompany());
//		v.setPictures(visitor.getPictures());
		visitorRepository.save(v);
	}
	
}
