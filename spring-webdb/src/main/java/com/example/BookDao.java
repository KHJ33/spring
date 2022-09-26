package com.example;

import java.util.List;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.springframework.jdbc.core.*;

public class BookDao {

	private JdbcTemplate jdbcTemplate;

	BookDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Book> selectAll() {
		List<Book> results = jdbcTemplate.query("select * from BOOK",
				(ResultSet rs, int rowNum) -> {
				Book book = new Book( rs.getLong("NUMBER"), rs.getString("NAME")
						, rs.getString("BORROW"), rs.getString("RESERVATION"));
				
				book.setNumber(rs.getLong("NUMBER"));
				return book;
				});
		
		return results;
	}
	
	public void insert(Book book) {
		jdbcTemplate.update("insert into BOOK (NUMBER, NAME, BORROW, RESERVATION) "
				+" values (?, ?, ?, ?) ", book.getNumber(), book.getName(), book.getBorrow(), book.getReservation());
	}
	
	public void delete(String number) {
		jdbcTemplate.update("delete from BOOK WHERE NUMBER ="+number);
	}
	
	public void borrow(String number, String id) {
		jdbcTemplate.update("update BOOK set BORROW = ? "
				+ " where NUMBER = ? ",id,number);
	}
	
	public void reservation(String number, String id) {
		jdbcTemplate.update("update BOOK set RESERVATION = ? "
				+ " where NUMBER = ? ",id,number);
	}
	
	public void reservation_to_borrow(String number, String id) {
		jdbcTemplate.update("update BOOK set RESERVATION = ?,BORROW=? "
				+ " where NUMBER = ? ","",id,number);
	}
	
	public List<Book> selectID(String id) {
		List<Book> results = jdbcTemplate.query("select * from BOOK where BORROW='"+id+"'",
				(ResultSet rs, int rowNum) -> {
				Book book = new Book( rs.getLong("NUMBER"), rs.getString("NAME")
						, rs.getString("BORROW"), rs.getString("RESERVATION"));
				
				book.setNumber(rs.getLong("NUMBER"));
				return book;
				});
		
		return results;
	}
	
	public List<Book> selectRE() {
		List<Book> results = jdbcTemplate.query("select * from BOOK where not BORROW=''",
				(ResultSet rs, int rowNum) -> {
				Book book = new Book( rs.getLong("NUMBER"), rs.getString("NAME")
						, rs.getString("BORROW"), rs.getString("RESERVATION"));
				
				book.setNumber(rs.getLong("NUMBER"));
				return book;
				});
		
		return results;
	}
	
	public List<Book> selectName(String name) {
		List<Book> results = jdbcTemplate.query("select * from BOOK where NAME='"+name+"'",
				(ResultSet rs, int rowNum) -> {
				Book book = new Book( rs.getLong("NUMBER"), rs.getString("NAME")
						, rs.getString("BORROW"), rs.getString("RESERVATION"));
				
				book.setNumber(rs.getLong("NUMBER"));
				return book;
				});
		
		return results;
	}
}
