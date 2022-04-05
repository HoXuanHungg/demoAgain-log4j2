package com.example.demoAgain.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoAgain.DAO.UserThongTinDAO;
import com.example.demoAgain.Model.UserThongTinModel;

@Service
@Transactional

public class UserThongTinService {
	@Autowired
	private UserThongTinDAO userThongTinDAO;

	public List<UserThongTinModel> listAllUser() {
		List<UserThongTinModel> listUser = userThongTinDAO.listAllUser();
		return listUser;
	}

	public int statistical() {
		int sum = 0;
		sum = userThongTinDAO.statistical();
		return sum;
	}

	public void saveUser(UserThongTinModel userThongTinModel) {
		userThongTinDAO.saveUser(userThongTinModel);

	}

	public void updateUser(UserThongTinModel userThongTinModel) {
		userThongTinDAO.updateUser(userThongTinModel);

	}

	public void deteleUser(String id) {
		userThongTinDAO.deleteUser(id);

	}

	public int checkId(String id) {
		int number = 0;
		number = userThongTinDAO.CheckId(id);
		return number;
	}

	public UserThongTinModel deltailUser(String id) {
		return userThongTinDAO.findById(id);

	}
}
