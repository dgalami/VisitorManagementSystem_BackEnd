package com.visitorLog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class LogVisitor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int logId;
	
	@Column
	private String logDate;
	
	@Column
	private String logInTime;
	
	@Column
	private String logOutTime;
	
	@Column
	private String reason;
	
	@Column
	private int vId;
	
	@Column
	private int eId;
	
	@OneToOne
	@JoinColumn(name = "vID", updatable = false, insertable=false)
	private Visitor visitor;
	
	@OneToOne
	@JoinColumn(name = "eID", updatable = false, insertable=false)
	private Employee employee;
	
	@Column
	private boolean checkedIn=false;

	public LogVisitor() {
		super();
	}

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public String getLogInTime() {
		return logInTime;
	}

	public void setLogInTime(String logInTime) {
		this.logInTime = logInTime;
	}

	public String getLogOutTime() {
		return logOutTime;
	}

	public void setLogOutTime(String logOutTime) {
		this.logOutTime = logOutTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "LogVisitor [logId=" + logId + ", logDate=" + logDate + ", logInTime=" + logInTime + ", logOutTime="
				+ logOutTime + ", reason=" + reason + ", vId=" + vId + ", eId=" + eId + ", checkedIn=" + checkedIn
				+ "]";
	}

	
	
	

}
