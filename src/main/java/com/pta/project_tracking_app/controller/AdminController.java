package com.pta.project_tracking_app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pta.project_tracking_app.entity.Admin;
import com.pta.project_tracking_app.entity.Project;
import com.pta.project_tracking_app.entity.UserProjectAssign;
import com.pta.project_tracking_app.entity.UserRegister;
import com.pta.project_tracking_app.service.AdminService;

@Controller
@RequestMapping(value="/admin")
@SessionAttributes("adminDetails")
public class AdminController {
	
	@Autowired
	AdminService aService;
	
	@ModelAttribute("admin")
	public Admin getAdmin() {
		return new Admin();
	}
	
	@ModelAttribute("project")
	public Project getProject() {
		return new Project();
	}
	
	@ModelAttribute("userAssign")
	public UserProjectAssign getUPA() {
		return new UserProjectAssign();
	}
	
	@RequestMapping(value = "/login")
	public String getAdminForm() {
		return "admin-login";
	}
	
	@RequestMapping(value = "/dashboard")
	public String getAdminDashboard() {
		return "admin-dashboard";
	}
	
	@RequestMapping(value = "/project-list")
	public String getProjectList(Model model) {
		List<Project> list = aService.fetchProjects();
		model.addAttribute("projectList", list);
		return "project-list";
	}
	
	@RequestMapping(value = "/add-form")
	public String getProjectForm() {
		return "add-project";
	}
	
	@RequestMapping(value = "/success")
	public String processAddProject(@ModelAttribute("project") Project p) {
		aService.addProject(p);
		return "display";
	}
	
	@RequestMapping(value = "/updateForm")
	public String updateProject(@ModelAttribute("project") Project p, @RequestParam(value = "pid") int pid, Model model) {
		Project fetchedProject = aService.getProject(pid);
		model.addAttribute("currProject", fetchedProject);
		model.addAttribute("statusList", p.getStatusOptions());
		return "update-project";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String processUpdate(@ModelAttribute("project") Project p) {
		aService.updateProject(p);
		return "redirect:/admin/project-list";
	}
	
	@RequestMapping(value = "/deleteRecord")
	public String deleteProject(@RequestParam(value = "pid") int pid) {
		aService.removeProject(pid);
		return "redirect:/admin/project-list";
	}
	
	@RequestMapping(value = "/user-list")
	public String getUserData(Model model) {
		List<UserRegister> userList = aService.fetchUsers();
		model.addAttribute("userList", userList);
		return "user-list";
	}
	
	@RequestMapping(value = "/assign-form")
	public String getAssignForm() {
		return "assign-form";
	}
	
	@RequestMapping(value = "/assign-success")
	public String processAssign(@ModelAttribute("userAssign") UserProjectAssign upa) {
		aService.assignProject(upa);
		return "display";
	}
	
	@RequestMapping(value = "/redirect")
	public String processAdminLogin(@ModelAttribute("admin") Admin admin, Model model) {
		Admin currAdmin = aService.fetchAdmin(admin.getAname());
		if (currAdmin != null) {
			if (currAdmin.getPass().equals(admin.getPass())) {
				model.addAttribute("adminDetails", currAdmin);
				return "redirect:/admin/dashboard";
			}
			else {
				return "redirect:/admin/login";
			}
		}
		else {
			return "redirect:/admin/login";
		}
	}
	
	@RequestMapping(value = "/logout")
	public String adminLogout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.invalidate();
		return "redirect:/";
	}
}
