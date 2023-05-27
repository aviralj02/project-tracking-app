package com.pta.project_tracking_app.dao;

import java.util.List;

import com.pta.project_tracking_app.entity.Admin;
import com.pta.project_tracking_app.entity.Project;
import com.pta.project_tracking_app.entity.UserProjectAssign;
import com.pta.project_tracking_app.entity.UserRegister;

public interface AdminDao {
	public Admin getAdmin(String aname);
	public List<Project> getProjects();
	public int updateProject(Project p);
	public int createProject(Project p);
	public List<UserRegister> getUsers();
	public Project getProject(int pid);
	public int deleteProject(int pid);
	public int assignProject(UserProjectAssign upa);
}
