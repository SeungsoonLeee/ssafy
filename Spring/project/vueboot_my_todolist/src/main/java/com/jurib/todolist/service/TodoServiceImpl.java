package com.jurib.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jurib.todolist.dao.TodoDAO;
import com.jurib.todolist.dto.Todo;

@Transactional
@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoDAO todoDao;
	
	@Override
	public boolean addTodo(Todo todo) {
		return todoDao.insertTodo(todo);
	}

	@Override
	public boolean modifyTodo(Todo todo) {
		return todoDao.updateTodo(todo);
	}

	@Override
	public boolean removeTodo(int no) {
		return todoDao.deleteTodo(no);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Todo> findTodoList(String userId) {
		return todoDao.selectTodoList(userId);
	}

	@Override
	public Todo findTodo(int no) {
		return todoDao.selectTodo(no);
	}

	@Override
	public boolean removeTodoList(String userId) {
		return todoDao.deleteTodoList(userId);
	}

	@Override
	public boolean completeTodo(int no) {
		return todoDao.updateTodoDone(no);
	}

}
