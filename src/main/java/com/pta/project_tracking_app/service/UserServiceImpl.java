package com.pta.project_tracking_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pta.project_tracking_app.dao.UserDao;
import com.pta.project_tracking_app.entity.Project;
import com.pta.project_tracking_app.entity.User2Project;
import com.pta.project_tracking_app.entity.UserRegister;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao uDao;
	
	@Override
	public void registerUser(UserRegister newUser) {
		uDao.insertRecord(newUser);
	}

	@Override
	public UserRegister fetchUser(String uname) {
		UserRegister details = uDao.getUser(uname);
		
		return details;
	}

	@Override
	public List<User2Project> getUserProjects(String user) {
		List<User2Project> uplist = uDao.fetchUserProjects(user);
		return uplist;
	}

	@Override
	public int updateProject(Project p) {
		int result = uDao.updateProject(p);
		return result;
	}

	@Override
	public Project getProject(int pid) {
		Project p = uDao.getProject(pid);
		return p;
	}

}
