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

import com.visitorLog.entity.LogVisitor;
import com.visitorLog.entity.TempLog;
import com.visitorLog.service.LogVisitorService;

@CrossOrigin
@RestController
@RequestMapping(value = "/log")
public class LogVisitorController {

	@Autowired
	LogVisitorService logVisitorService;
	
	
	//getAlll
	@RequestMapping(value="/getAllLog", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LogVisitor>> getAll(){
		List<LogVisitor> log = logVisitorService.getAll();
		return new ResponseEntity<>(log, HttpStatus.OK);
	}
	
	//save appointment
	@RequestMapping(value="/saveLog",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveLog(@RequestBody TempLog tLog){
		System.out.println("Temp Log test-- " + tLog.toString());
//		System.out.println("Visitor id- " + tLog.getVisitorsId());
	
		//loop through tempLog and save each log with length of visitor array
				for(int i = 0; i < tLog.getVisitorsId().size(); i++) {
					String str =   String.valueOf(tLog.getVisitorsId().get(i));
					String str1[] = str.split(",");
					String str2[] = str1[0].split("=");
					System.out.println(str2[1]);
					
					
					LogVisitor v = new LogVisitor();
					v.setLogDate(tLog.getLogDate());
					v.setLogInTime(tLog.getLogInTime());
					v.setLogOutTime(tLog.getLogOutTime());
					v.setReason(tLog.getReason());
					v.seteId(tLog.geteId());
					v.setvId(Integer.parseInt(str2[1]));
//					v.setCheckedIn(true);	//get this true if user checked in
					logVisitorService.save(v);
				}
			
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//update
	@RequestMapping(value="/updateLog",method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LogVisitor> updateLog(@RequestBody LogVisitor log){
		logVisitorService.update(log, log.getLogId());
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	//delete
	@RequestMapping(value="/deleteLog/{id}",method=RequestMethod.DELETE,
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteLog(@PathVariable int id){
		logVisitorService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	//get list of expected appointment
	@RequestMapping(value="/getAllAppointment",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LogVisitor>> getAllAppointment(){
		List<LogVisitor> log  = logVisitorService.getAllAppointment();
		if(log.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		System.out.println("---get all appointment works");
		return new ResponseEntity<>(log, HttpStatus.OK);
	}
	
	//get currently logged in
	@RequestMapping(value="/getLoggedIn",method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LogVisitor>> getAppointment(){
		List<LogVisitor> log  = logVisitorService.getLoggedIn();
		if(log.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(log, HttpStatus.OK);
	}
	
	//get currently logged in
		@RequestMapping(value="/getLoggedOut",method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<LogVisitor>> getAppointmentOut(){
			List<LogVisitor> log  = logVisitorService.getLoggedOut();
			if(log.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(log, HttpStatus.OK);
		}
	
	
}
