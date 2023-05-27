package com.pta.project_tracking_app.service;

import java.util.List;

import com.pta.project_tracking_app.entity.Project;
import com.pta.project_tracking_app.entity.User2Project;
import com.pta.project_tracking_app.entity.UserRegister;

public interface UserService {
	public void registerUser(UserRegister newUser);
	public UserRegister fetchUser(String uname);
	public List<User2Project> getUserProjects(String user);
	public int updateProject(Project p);
	public Project getProject(int pid);
}
