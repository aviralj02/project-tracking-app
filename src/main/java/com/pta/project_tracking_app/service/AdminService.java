package com.pta.project_tracking_app.service;

import java.util.List;

import com.pta.project_tracking_app.entity.Admin;
import com.pta.project_tracking_app.entity.Project;
import com.pta.project_tracking_app.entity.UserProjectAssign;
import com.pta.project_tracking_app.entity.UserRegister;

public interface AdminService {
	public Admin fetchAdmin(String adminName);
	public List<Project> fetchProjects();
	public int updateProject(Project p);
	public int addProject(Project p);
	public List<UserRegister> fetchUsers();
	public Project getProject(int pid);
	public int removeProject(int pid);
	public int assignProject(UserProjectAssign upa);
}
