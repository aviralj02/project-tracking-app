package com.pta.project_tracking_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pta.project_tracking_app.dao.AdminDao;
import com.pta.project_tracking_app.entity.Admin;
import com.pta.project_tracking_app.entity.Project;
import com.pta.project_tracking_app.entity.UserProjectAssign;
import com.pta.project_tracking_app.entity.UserRegister;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao aDao;
	
	@Override
	public Admin fetchAdmin(String adminName) {
		Admin admin = aDao.getAdmin(adminName);
		if (admin != null) {
			return admin;
		} else {
			return null;
		}
	}

	@Override
	public List<Project> fetchProjects() {
		List<Project> ls = aDao.getProjects();
		return ls;
	}

	@Override
	public int updateProject(Project p) {
		int result = aDao.updateProject(p);
		return result;
	}

	@Override
	public int addProject(Project p) {
		int result = aDao.createProject(p);
		return result;
	}

	@Override
	public List<UserRegister> fetchUsers() {
		List<UserRegister> ulist = aDao.getUsers();
		return ulist;
	}

	@Override
	public Project getProject(int pid) {
		Project p = aDao.getProject(pid);
		return p;
	}

	@Override
	public int removeProject(int pid) {
		int result = aDao.deleteProject(pid);
		return result;
	}

	@Override
	public int assignProject(UserProjectAssign upa) {
		int result = aDao.assignProject(upa);
		return result;
	}

}
