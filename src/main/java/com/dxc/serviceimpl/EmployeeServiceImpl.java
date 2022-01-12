package com.dxc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dxc.dao.EmployeeDAO;
import com.dxc.model.Employee;
import com.dxc.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	
	EmployeeDAO employeeDAO=new EmployeeDAO();

	EmployeeDAO employeeDAO1=new EmployeeDAO();

	EmployeeDAO employeeDAO2=new EmployeeDAO();


	@Override
	public List<Employee> selectEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> updateEmployee(Employee emp) {
		
		return employeeDAO1.updateEmployee(emp);
	}

	@Override
	public List<Employee> deleteEmployee(Integer id) {
	
		return employeeDAO2.deleteEmployee(id);
	}

	@Override
	public List<Employee> insertEmployee(Employee emp) {
		
		return employeeDAO.insertEmployee(emp);
	}

}
