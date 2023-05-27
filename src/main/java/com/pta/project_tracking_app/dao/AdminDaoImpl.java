package com.pta.project_tracking_app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pta.project_tracking_app.entity.Admin;
import com.pta.project_tracking_app.entity.Project;
import com.pta.project_tracking_app.entity.UserProjectAssign;
import com.pta.project_tracking_app.entity.UserRegister;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public Admin getAdmin(String aname) {
		String query = "Select * From admin Where aname='"+aname+"';";
		Admin ad = jdbc.query(query, new ResultSetExtractor<Admin>() {

			@Override
			public Admin extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Admin a = new Admin();
					a.setAname(rs.getString("aname"));
					a.setPass(rs.getString("password"));
					
					return a;
				}
				return null;
			}
			
		});
		return ad;
	}
	
	@Override
	public List<Project> getProjects() {
		String query = "SELECT * FROM project;";
		List<Project> lp = jdbc.query(query, new RowMapper<Project>() {

			@Override
			public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
				Project p = new Project();
				p.setPid(rs.getInt("pid"));
				p.setPname(rs.getString("pname"));
				p.setComments(rs.getString("comments"));
				p.setStatus(rs.getString("status"));
				return p;
			}
			
		});
		return lp;
	}

	@Override
	public int updateProject(Project p) {
		String update = "Update project Set pname=?, comments=?, status=? Where pid=?;";
		Object[] arr = {p.getPname(), p.getComments(), p.getStatus(), p.getPid()};
		
		int result = jdbc.update(update, arr);
		return result;
	}

	@Override
	public int createProject(Project p) {
		String create = "Insert Into Project Values (?,?,?,?);";
		Object[] arr = {p.getPid(), p.getPname(), p.getComments(), p.getStatus()};
		
		int result = jdbc.update(create, arr);
		return result;
	}

	@Override
	public List<UserRegister> getUsers() {
		String query = "Select * From user;";
		List<UserRegister> ulist = jdbc.query(query, new RowMapper<UserRegister>() {

			@Override
			public UserRegister mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserRegister user = new UserRegister();
				user.setUsername(rs.getString("uname"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		});
		return ulist;
	}

	@Override
	public Project getProject(int pid) {
		String query = "Select * From project Where pid="+pid+";";
		Project project = jdbc.query(query, new ResultSetExtractor<Project>() {

			@Override
			public Project extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Project p = new Project();
					p.setPid(rs.getInt("pid"));
					p.setPname(rs.getString("pname"));
					p.setComments(rs.getString("comments"));
					p.setStatus(rs.getString("status"));
					return p;
				}
				return null;
			}
			
		});
		return project;
	}

	@Override
	public int deleteProject(int pid) {
		String delete = "Delete from project where pid="+pid+";";
		int result = jdbc.update(delete);
		return result;
	}

	@Override
	public int assignProject(UserProjectAssign upa) {
		String assign = "insert into user2project values (?,?);";
		Object[] arr = {upa.getUsername(), upa.getPid()};
		int result = jdbc.update(assign, arr);
		return result;
	}

}
