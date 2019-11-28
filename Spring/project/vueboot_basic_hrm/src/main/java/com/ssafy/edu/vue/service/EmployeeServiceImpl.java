package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.EmployeeDAO;
import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.EmployeeDto;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
    @Autowired
	private EmployeeDAO employeeDao;

    @Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findAllEmployees() throws Exception {
		return employeeDao.findAllEmployees();
	}
    
    @Override
	@Transactional(readOnly=true)
	public int getEmployeesTotal() throws Exception {
		return employeeDao.getEmployeesTotal();
	}

    @Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findLikeEmployees(String name) throws Exception {
    	return employeeDao.findLikeEmployees(name);
	}

	@Override
	@Transactional
	public boolean addEmployee(EmployeeDto emp) throws Exception {
		return employeeDao.addEmployee(emp);
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepartmentDto> findAllDepartments() throws Exception {
		return employeeDao.findAllDepartments();
	}

	@Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findAllTitles() throws Exception {
		return employeeDao.findAllTitles();
	}

	@Override
	@Transactional(readOnly=true)
	public EmployeeDto findEmployeeById(int id) throws Exception {
		return employeeDao.findEmployeeById(id);
	}

	@Override
	@Transactional
	public boolean updateEmployee(EmployeeDto emp) throws Exception {
		return employeeDao.updateEmployee(emp);
	}

	@Override
	@Transactional
	public boolean deleteEmployee(int id) throws Exception {
		return employeeDao.deleteEmployee(id);
	}

	@Transactional(readOnly=true)
	@Override
	public EmployeeDto findEmployeeWithMaster(int id) throws Exception {
		return employeeDao.selectEmployeeWithMaster(id);
	}

	@Transactional(readOnly=true)
	@Override
	public DepartmentDto findDeptByIdWithEmployees(int id) throws Exception {
		return employeeDao.selectDeptByIdWithEmployees(id);
	}
	
}






