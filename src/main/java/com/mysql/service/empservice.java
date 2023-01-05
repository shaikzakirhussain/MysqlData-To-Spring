package com.mysql.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mysql.model.empModel;

@Repository
public interface empservice {

	public  List<empModel> getempData();

}
