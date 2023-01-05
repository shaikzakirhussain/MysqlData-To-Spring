package com.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.model.empModel;
import com.mysql.service.empservice;

@RestController
public class empController {

	@Autowired
	private empservice empservice;
		
	@GetMapping("/employees")
	public List<empModel> getemployee(){
		
		return this.empservice.getempData();
	}
}
