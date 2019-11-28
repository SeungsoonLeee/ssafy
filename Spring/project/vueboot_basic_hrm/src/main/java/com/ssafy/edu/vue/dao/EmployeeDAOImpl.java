package com.ssafy.edu.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.EmployeeDto;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
    private String ns="com.ssafy.edu.vue.dao.HrmMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<EmployeeDto> findAllEmployees() throws Exception {
		return sqlSession.selectList(ns+"findAllEmployees");
	}

	@Override
	public int getEmployeesTotal() throws Exception{
		return sqlSession.selectOne(ns+"getEmployeesTotal");
	}

	@Override
	public List<EmployeeDto> findLikeEmployees(String name) throws Exception {
		return sqlSession.selectList(ns+"findLikeEmployees",name);
	}

	@Override
	public List<DepartmentDto> findAllDepartments() throws Exception {
		return sqlSession.selectList(ns+"findAllDepartments");
	}

	@Override
	public List<EmployeeDto> findAllTitles() throws Exception {
		return sqlSession.selectList(ns+"findAllTitles");
	}

	@Override
	public EmployeeDto findEmployeeById(int id) throws Exception {
		return sqlSession.selectOne(ns+"findEmployeeById",id);
	}

	@Override
	public boolean addEmployee(EmployeeDto emp) throws Exception {
		return sqlSession.insert(ns+"addEmployee",emp) > 0;
	}

	@Override
	public boolean updateEmployee(EmployeeDto emp) throws Exception {
		 return sqlSession.update(ns+"updateEmployee",emp) > 0;
	}

	@Override
	public boolean deleteEmployee(int id) throws Exception {
		return sqlSession.delete(ns+"deleteEmployee",id) > 0;
	}

	@Override
	public EmployeeDto selectEmployeeWithMaster(int id) throws Exception {
		return sqlSession.selectOne(ns+"selectEmployeeWithMaster", id);
	}

	@Override
	public DepartmentDto selectDeptByIdWithEmployees(int id) throws Exception {
		return sqlSession.selectOne(ns+"selectDeptByIdWithEmployees", id);
	}
	
	
	
}
