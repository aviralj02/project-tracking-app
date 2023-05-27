package com.pta.project_tracking_app.entity;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private int pid;
	private String pname;
	private String comments;
	private String status;
	private List<String> statusOptions;
	
	
	public Project() {
		statusOptions = new ArrayList<>();
		statusOptions.add("TO DO");
		statusOptions.add("IN PROGRESS");
		statusOptions.add("COMPLETE");
		
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<String> getStatusOptions() {
		return statusOptions;
	}
	public void setStatusOptions(List<String> statusOptions) {
		this.statusOptions = statusOptions;
	}
}
