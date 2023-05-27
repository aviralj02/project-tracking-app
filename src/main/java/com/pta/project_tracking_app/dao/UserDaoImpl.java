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

import com.pta.project_tracking_app.entity.Project;
import com.pta.project_tracking_app.entity.User2Project;
import com.pta.project_tracking_app.entity.UserRegister;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public int insertRecord(UserRegister user) {
		String query = "INSERT INTO user VALUES (?,?,?);";
		Object[] arr = { user.getUsername(), user.getEmail(), user.getPassword() };

		int result = jdbc.update(query, arr);

		return result;
	}

	@Override
	public UserRegister getUser(String uname) {
		String query = "SELECT * FROM user WHERE uname='" + uname + "';";
		UserRegister user = jdbc.query(query, new ResultSetExtractor<UserRegister>() {

			@Override
			public UserRegister extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					UserRegister u = new UserRegister();
					u.setUsername(rs.getString("uname"));
					u.setEmail(rs.getString("email"));
					u.setPassword(rs.getString("password"));

					return u;
				}
				return null;
			}

		});

		return user;
	}

	@Override
	public List<User2Project> fetchUserProjects(String user) {
		String query = "Select * from (project JOIN user2project on project=pid) Where user='" + user + "';";
		List<User2Project> list = jdbc.query(query, new RowMapper<User2Project>() {

			@Override
			public User2Project mapRow(ResultSet rs, int rowNum) throws SQLException {
				User2Project up = new User2Project();
				up.setPid(rs.getInt("pid"));
				up.setPname(rs.getString("pname"));
				up.setComments(rs.getString("comments"));
				up.setStatus(rs.getString("status"));
				up.setUser(rs.getString("user"));
				up.setProject(rs.getInt("project"));
				return up;
			}

		});
		return list;
	}

	@Override
	public Project getProject(int pid) {
		String query = "Select * From project Where pid=" + pid + ";";
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
	public int updateProject(Project p) {
		String update = "Update project Set pname=?, comments=?, status=? Where pid=?;";
		Object[] arr = {p.getPname(), p.getComments(), p.getStatus(), p.getPid()};
		
		int result = jdbc.update(update, arr);
		return result;
	}
}
