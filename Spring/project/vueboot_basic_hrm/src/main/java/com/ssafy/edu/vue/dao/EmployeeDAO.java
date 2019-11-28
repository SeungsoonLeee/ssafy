package com.ssafy.edu.vue.dao;

import java.util.List;

import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.EmployeeDto;

public interface EmployeeDAO {

	List<EmployeeDto> findAllEmployees() throws Exception;

	int getEmployeesTotal() throws Exception;

	List<EmployeeDto> findLikeEmployees(String name) throws Exception;


	List<DepartmentDto> findAllDepartments() throws Exception;

	List<EmployeeDto> findAllTitles() throws Exception;

	EmployeeDto findEmployeeById(int id) throws Exception;
	
	boolean addEmployee(EmployeeDto emp) throws Exception;

	boolean updateEmployee(EmployeeDto emp) throws Exception;

	boolean deleteEmployee(int id) throws Exception;

	////////////////////////////////////join
	public EmployeeDto selectEmployeeWithMaster(int id) throws Exception;
	public DepartmentDto selectDeptByIdWithEmployees(int id) throws Exception;
}







