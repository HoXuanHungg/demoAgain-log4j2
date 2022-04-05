package com.example.demoAgain.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demoAgain.Model.UserThongTinModel;

public class UserThongTinMapper implements RowMapper<UserThongTinModel>{
	public UserThongTinModel mapRow(ResultSet result, int rowNum) throws SQLException {
		UserThongTinModel userThongTinModel = new UserThongTinModel();
		userThongTinModel.setId(result.getString("id"));
		userThongTinModel.setName(result.getString("name"));
		
		return userThongTinModel;
	}
}
