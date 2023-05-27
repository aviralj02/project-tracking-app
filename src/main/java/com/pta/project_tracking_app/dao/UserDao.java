package com.pta.project_tracking_app.dao;

import java.util.List;

import com.pta.project_tracking_app.entity.Project;
import com.pta.project_tracking_app.entity.User2Project;
import com.pta.project_tracking_app.entity.UserRegister;

public interface UserDao {
	public int insertRecord(UserRegister user);
	public UserRegister getUser(String uname);
	public List<User2Project> fetchUserProjects(String user);
	public Project getProject(int pid);
	public int updateProject(Project p);
}
