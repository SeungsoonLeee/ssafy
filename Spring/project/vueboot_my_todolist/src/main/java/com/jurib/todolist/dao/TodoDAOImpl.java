package com.jurib.todolist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jurib.todolist.dto.Todo;

@Repository
public class TodoDAOImpl implements TodoDAO {

	@Autowired
	private SqlSession session;
	private String ns = "com.jurib.todolist.dao.TodoMapper.";
	
	@Override
	public boolean insertTodo(Todo todo) {
		return session.insert(ns+"insertTodo", todo)>0;
	}

	@Override
	public boolean updateTodo(Todo todo) {
		return session.insert(ns+"updateTodo", todo)>0;
	}

	@Override
	public boolean deleteTodo(int no) {
		return session.insert(ns+"deleteTodo", no)>0;
	}

	@Override
	public List<Todo> selectTodoList(String userId) {
		return session.selectList(ns+"selectTodoList",userId);
	}

	@Override
	public Todo selectTodo(int no) {
		return session.selectOne(ns+"selectTodo", no);
	}

	@Override
	public boolean deleteTodoList(String userId) {
		return session.delete(ns+"deleteTodoList",userId)>0;
	}

	@Override
	public boolean updateTodoDone(int no) {
		return session.update(ns+"updateTodoDone", no)>0;
	}

}
