package com.example.demoAgain.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoAgain.Model.UserThongTinModel;
import com.example.demoAgain.Service.UserThongTinService;

@RestController
@RequestMapping("/api")
public class UserThongTinAPI {
	@Autowired
	private UserThongTinService userThongTinService;

	// Thong ke sinh vien
	@GetMapping("/statistical")
	public int statistical() {
		return userThongTinService.statistical();
	}

	@GetMapping("/listAllUser")
	public List<UserThongTinModel> listAllUser() {
		return (List<UserThongTinModel>) userThongTinService.listAllUser();
	}

	@PostMapping("/saveUser")
	public void saveUser(@RequestBody UserThongTinModel userThongTinModel) {
		userThongTinService.saveUser(userThongTinModel);
	}

	@PutMapping("/updateUser")
	public void updateUser(@RequestBody UserThongTinModel userThongTinModel) {
		userThongTinService.updateUser(userThongTinModel);
	}

	@DeleteMapping("deleteUser/{id}")
	public void deleteUser(@PathVariable String id) {
		userThongTinService.deteleUser(id);
	}

	@GetMapping("/checkId/{id}")
	public int checkIdUser(@PathVariable String id) {
		return userThongTinService.checkId(id);
	}
}
