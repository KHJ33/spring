package com.example;

import java.util.List;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.springframework.jdbc.core.*;

public class ManagerDao {

	private JdbcTemplate jdbcTemplate;

	public ManagerDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Manager> selectAll() {
		List<Manager> results = jdbcTemplate.query("select * from Manager",
				(ResultSet rs, int rowNum) -> {
				Manager manager = new Manager( rs.getString("ID"), rs.getString("PASSWORD"));
				
				manager.setId(rs.getString("ID"));
				return manager;
				});
		
		return results;
	}
	
	public void insert(Manager manager) {
		jdbcTemplate.update("insert into MANAGER (ID, PASSWORD) "
				+" values (?, ?) ", manager.getId(), manager.getPassword());
	}
}
