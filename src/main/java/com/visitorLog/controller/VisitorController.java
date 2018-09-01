package com.visitorLog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.visitorLog.entity.Visitor;
import com.visitorLog.service.VisitorService;

@CrossOrigin
@RestController
@RequestMapping(value = "/visitor")
public class VisitorController {

	@Autowired
	VisitorService visitorService;
	
	//save visitor to database
	@RequestMapping(value = "/save",method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Visitor> save(@RequestBody Visitor visitor) {
		//check if already exist
		Visitor v = visitorService.findVisitorById(visitor.getvId());
		if(v != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<>(visitorService.addNewVisitor(visitor),HttpStatus.OK);
	}
	
	//get all visitors
	@RequestMapping(value="/getAll",method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Visitor>> getAllVisitor(){
		List<Visitor> visitors = visitorService.getAllVisitor();
		System.out.println("---get all visitor works");
		return new ResponseEntity<>(visitors,HttpStatus.OK);
	}
	
	//search visitor
	@RequestMapping(value="/search/{value}",method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Visitor>> search(@PathVariable String value){
		return new ResponseEntity<>(visitorService.search(value), HttpStatus.OK);
	}
	
	//find by id
	@RequestMapping(value="/fidById/{id}",method=RequestMethod.GET, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Visitor> findById(@PathVariable int id){
		Visitor v = visitorService.findVisitorById(id);
		if(v == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(v,HttpStatus.OK);
	}
	
	//delete Visitor
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable int id){
		visitorService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//update visitor info
	@RequestMapping(value="/update",method=RequestMethod.PUT, 
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Visitor> update(@RequestBody Visitor visitor){
		visitorService.update(visitor.getvId(), visitor);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
