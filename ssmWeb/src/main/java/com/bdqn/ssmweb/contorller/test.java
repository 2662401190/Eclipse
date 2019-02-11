package com.bdqn.ssmweb.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdqn.ssmweb.bean.Employee;
import com.bdqn.ssmweb.dao.EmployeeMapper;

@Controller
public class test {

	
	@Autowired
	EmployeeMapper employeeMapper;
	
	
	@RequestMapping("/emp/{id}")
	public String  ss(@PathVariable("id") Integer id) {
		
		System.out.println("½øÀ´");
		employeeMapper.selectByPrimaryKey(id);
		return "ss" ;
	}
}
