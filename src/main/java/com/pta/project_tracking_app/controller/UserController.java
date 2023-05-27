package com.pta.project_tracking_app.controller;

import java.io.IOException;
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

import com.pta.project_tracking_app.entity.Project;
import com.pta.project_tracking_app.entity.User2Project;
import com.pta.project_tracking_app.entity.UserLogin;
import com.pta.project_tracking_app.entity.UserRegister;
import com.pta.project_tracking_app.service.UserService;

@Controller
@RequestMapping(value = "/client")
@SessionAttributes("userDetails")
public class UserController {
	
	@Autowired
	UserService service;
	
	@ModelAttribute("user")
	public UserLogin getUserLogin() {
		return new UserLogin();
	}
	
	@ModelAttribute("project")
	public Project getProject() {
		return new Project();
	}
	
	@RequestMapping(value = "/dashboard")
	public String getDashBoard(@RequestParam(value = "uname") String user, Model model) {
		List<User2Project> uplist = service.getUserProjects(user);
		model.addAttribute("userProjectsList", uplist);
		return "user-dashboard";
	}
	
	@RequestMapping(value = "/updateStatus")
	public String updateStatusForm(@ModelAttribute("project") Project p, @RequestParam(value = "pid") int pid, Model model) {
		Project fetchedProject = service.getProject(pid);
		model.addAttribute("projectData", fetchedProject);
		model.addAttribute("statusList", p.getStatusOptions());
		return "update-project-status";
	}
	
	@RequestMapping(value = "/processStatusUpdate")
	public String processStatusUpdate(@ModelAttribute("project") Project p, @RequestParam(value = "uname") String uname) {
		service.updateProject(p);
		return "redirect:/client/dashboard?uname="+uname;
	}
	
	@RequestMapping(value = "/processing", method = RequestMethod.POST)
	public String processLogin(@ModelAttribute("user") UserLogin user, Model model) throws IOException {
		UserRegister userDetails = service.fetchUser(user.getUsername());
		if (userDetails != null) {
			if (userDetails.getPassword().equals(user.getPassword())) {
				model.addAttribute("userDetails", userDetails);
				return "redirect:/client/dashboard?uname="+userDetails.getUsername();
			}
			else {
				return "redirect:/";
			}
		}
		else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/logout")
	public String processLogout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.invalidate();
		return "redirect:/";
	}
}
