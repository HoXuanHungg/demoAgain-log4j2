package com.example.demoAgain.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserThongTinModel {
	@NotBlank(message = "Student may not be empty")
	@NotNull(message = "Student may not be null")
	private String id;
	
	@NotBlank(message = "Student may not be empty")
	@NotNull(message = "Student may not be null")
	private String name;
		
	public UserThongTinModel(
			@NotBlank(message = "Student may not be empty") @NotNull(message = "Student may not be null") String id,
			@NotBlank(message = "Student may not be empty") @NotNull(message = "Student may not be null") String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public UserThongTinModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
