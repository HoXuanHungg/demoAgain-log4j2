package com.example.demoAgain.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demoAgain.Mapper.UserThongTinMapper;
import com.example.demoAgain.Model.UserThongTinModel;



@Repository
@Transactional
public class UserThongTinDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<UserThongTinModel> listAllUser(){
		String sql = "SELECT * FROM user_thongtin";
		return jdbcTemplate.query(sql, new UserThongTinMapper());
	}
	public void saveUser(UserThongTinModel userThongTinModel) {
		if(CheckId(userThongTinModel.getId()) ==0) {
			String sql = "insert into user_thongtin (id, name) values (?, ?)";
			jdbcTemplate.update(sql, userThongTinModel.getId(), userThongTinModel.getName());
		}
	}
	
	public void deleteUser(String id) {
		String sql = "delete from user_thongtin where id = ?";
		jdbcTemplate.update(sql, id);
	}
	public void updateUser(UserThongTinModel userThongTinModel) {
		String sql = "update user_thongtin set name = ? where id = ?";
		jdbcTemplate.update(sql, userThongTinModel.getName(), userThongTinModel.getId());
		
	}
	public List<UserThongTinModel> findAll(String search){
		String sql  = "select * from user_thongtin where id like '%" + search +"%' or fullname like '%" + search +"%'";
		return jdbcTemplate.query(sql, new UserThongTinMapper());
	}
	
	public UserThongTinModel findById(String id) {
		String sql = "select * from user_thongtin where id = ?";
		return jdbcTemplate.queryForObject(sql, new UserThongTinMapper(), id);
	}
	public int CheckId(String id) {
		int number = 0;
		String sql = "select count(*) as sum from user_thongtin where id = '" + id + "'";
		number = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return number;
	}
	// Thống kê
	public int statistical() {
		int sum =0;
		
		String sql = "select count(id) as sum from user_thongtin";
		sum = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return sum;
		
	}
}
