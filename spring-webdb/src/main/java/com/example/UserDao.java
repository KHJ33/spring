package com.example;

import java.util.List;
import java.sql.ResultSet;

import javax.sql.DataSource;
import org.springframework.jdbc.core.*;


public class UserDao {

	private JdbcTemplate jdbcTemplate;

	public UserDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<User> selectAll() {
		List<User> results = jdbcTemplate.query("select * from USER",
				(ResultSet rs, int rowNum) -> {
				User user = new User( rs.getString("ID"), rs.getString("PASSWORD")
						, rs.getString("NAME"), rs.getString("PHONE"), rs.getString("ADDRESS"));
				
				user.setId(rs.getString("ID"));
				return user;
				});
		
		return results;
	}
	
	public void insert(User user) {
		jdbcTemplate.update("insert into USER (ID, PASSWORD, NAME, PHONE, ADDRESS) "
				+" values (?, ?, ?, ?, ?) "
				, user.getId(), user.getPwd(), user.getName(), user.getPhone(), user.getAddress());
	}
	
	public void update(User user) {
		jdbcTemplate.update("update USER set PASSWORD = ?, NAME = ?, PHONE = ?, ADDRESS = ? "
				+ " where ID = ? ",
				user.getPwd(),user.getName(),user.getPhone(),user.getAddress(),user.getId());
	}
}
