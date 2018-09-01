package com.visitorLog.entity;

import java.util.ArrayList;
import java.util.List;

public class TempLog {

	private int logId;
	private String logDate;
	private String logInTime;
	private String logOutTime;
	private String reason;
	private List visitorsId = new ArrayList();
	private int eId;

	public TempLog() {
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

	public List getVisitorsId() {
		return visitorsId;
	}

	public void setVisitorsId(List visitorsId) {
		this.visitorsId = visitorsId;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	@Override
	public String toString() {
		return "TempLog [logId=" + logId + ", logDate=" + logDate + ", logInTime=" + logInTime + ", logOutTime="
				+ logOutTime + ", reason=" + reason + ", visitorsId=" + visitorsId + ", eId=" + eId + "]";
	}

	

}
