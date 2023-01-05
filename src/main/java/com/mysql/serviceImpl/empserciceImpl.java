package com.mysql.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.dbUtil.DBUtil;
import com.mysql.model.empModel;
import com.mysql.service.empservice;

@Service
public class empserciceImpl implements empservice {

	@Autowired
	static List<empModel> employeelist = new ArrayList<>();
	
	Connection connection;
	
	public empserciceImpl() throws SQLException {
		
	connection = DBUtil.getConnection();	
	}
	
	
	@Override
	public List<empModel> getempData() {
	
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM emp");
			
			ResultSet rs  = stmt.executeQuery();
			while(rs.next()) {
				empModel emp = new empModel();
				emp.setName(rs.getString(1));
				emp.setEmail(rs.getString(2));
				emp.setGender(rs.getString(3));
				emp.setPhonenumber(rs.getInt(4));
				employeelist.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeelist;
	}

}