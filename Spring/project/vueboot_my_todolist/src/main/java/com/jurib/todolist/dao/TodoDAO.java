package com.jurib.todolist.dao;

import java.util.List;

import com.jurib.todolist.dto.Todo;

public interface TodoDAO {

	boolean insertTodo(Todo todo);
	boolean updateTodo(Todo todo);
	boolean deleteTodo(int no);
	List<Todo> selectTodoList(String userId);
	Todo selectTodo(int no);
	
	boolean deleteTodoList(String userId);
	boolean updateTodoDone(int no);
}
