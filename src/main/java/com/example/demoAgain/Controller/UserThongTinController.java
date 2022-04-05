package com.example.demoAgain.Controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demoAgain.Model.UserThongTinModel;
import com.example.demoAgain.Service.UserThongTinService;

@Controller
public class UserThongTinController {
	//tạo biến static khai báo Logger dùng slf4j
	private static final Logger LOGGER = LoggerFactory.getLogger(UserThongTinController.class);
	@Autowired
	private UserThongTinService UserThongTinService;

	@GetMapping("/index")
	public String index(Model model) {
		
		LOGGER.trace("for tracing purpose");
		LOGGER.debug("for debugging purpose");
		LOGGER.info("for informational purpose");
		LOGGER.warn("for warning purpose");
		LOGGER.error("for logging errors");
		
		model.addAttribute("User_save", new UserThongTinModel());
		model.addAttribute("listUser", UserThongTinService.listAllUser());
		// thong ke sinh vien
		model.addAttribute("statistical", UserThongTinService.statistical());
		return "index";
	}

	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute("user_save") @Validated UserThongTinModel UserThongTinModel,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("listUser", UserThongTinService.listAllUser());
			// thong ke sinh vien
			model.addAttribute("statistical", UserThongTinService.statistical());
			return "index";
		}

		UserThongTinService.saveUser(UserThongTinModel);
		model.addAttribute("listUser", UserThongTinService.listAllUser());
		return "redirect:/";
	}

	@RequestMapping("/deleteUser/{idUser}")
	public String deleteUser(@PathVariable String id, Model model) {
		UserThongTinService.deteleUser(id);
		model.addAttribute("listUser", UserThongTinService.listAllUser());
		return "redirect:/";
	}

	@RequestMapping("/updateUser/{idUser}")
	public String showUpdate(@PathVariable String id, Model model) {
		UserThongTinModel detailUser = UserThongTinService.deltailUser(id);
		model.addAttribute("user_update", new UserThongTinModel());
		model.addAttribute("detailUser", detailUser);
		return "updateUser";
	}

	@RequestMapping("/updateStudent")
	public String updateUser(@ModelAttribute("user_update") @Valid UserThongTinModel UserThongTinModel, Model model) {
		UserThongTinService.updateUser(UserThongTinModel);
		return "redirect:/";
	}

}
