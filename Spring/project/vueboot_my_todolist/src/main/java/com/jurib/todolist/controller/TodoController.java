package com.jurib.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jurib.todolist.dto.Result;
import com.jurib.todolist.dto.Todo;
import com.jurib.todolist.service.TodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/todolist")
@RestController
@Api("TodoList Rest API")
public class TodoController {

	@Autowired
	private TodoService todoService;

	// @GetMapping("/hello")
	public String hello() {
		return "hello world~!~";
	}

	@ApiOperation(value="사용자의 새로운 할일을 등록한다.", response=Result.class)
	@PostMapping("/todo")
	public ResponseEntity<Result> addTodo(@RequestBody Todo todo) { // @RestController이어도 @RequestBody 생략하면 안됨.
		System.out.println(todo);
		boolean flag = todoService.addTodo(todo);
		if (flag) {
			return new ResponseEntity<Result>(new Result(true, "새로운 todo가 등록되었습니다. : " + todo.getNo()), HttpStatus.OK);
		} 
		return new ResponseEntity<Result>(new Result(false, "todo 등록에 실패하였습니다."), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ApiOperation(value="등록되어 있는 할일을 수정한다.", response=Result.class)
	@PutMapping("/todo/{no}")
	public ResponseEntity<Result> modifyTodo(@PathVariable int no, @RequestBody Todo todo) {
		boolean flag = todoService.modifyTodo(todo);
		if (flag) {
			return new ResponseEntity<Result>(new Result(true, "todo가 수정되었습니다. : " + no), HttpStatus.OK);
		}
		return new ResponseEntity<Result>(new Result(false, "todo 수정에 실패하였습니다."), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	@ApiOperation(value="등록되어 있는 할일을 삭제한다.", response=Result.class)
	@DeleteMapping("/todo/{no}")
	public ResponseEntity<Result> removeTodo(@PathVariable int no) {
		boolean flag = todoService.removeTodo(no);
		if (flag) {
			return new ResponseEntity<Result>(new Result(true, "todo가 삭제되었습니다. : " + no), HttpStatus.OK);
		}
		return new ResponseEntity<Result>(new Result(false, "todo 삭제에 실패하였습니다."), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ApiOperation(value="등록되어 있는 할일을 조회한다.", response=Todo.class)
	@GetMapping("/todo/{no}")
	public ResponseEntity<Todo> findTodo(@PathVariable int no) {
		Todo todo = todoService.findTodo(no);
		if (todo != null) {
			return new ResponseEntity<Todo>(todo, HttpStatus.OK);
		}
		return new ResponseEntity<Todo>(HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value="사용자의 모든 할일목록을 조회한다.", response=List.class)
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Todo>> findTodoList(@PathVariable String userId) {
		List<Todo> todoList = todoService.findTodoList(userId);
		if (todoList.size() > 0) {
			return new ResponseEntity<List<Todo>>(todoList, HttpStatus.OK);
		}
		return new ResponseEntity<List<Todo>>(HttpStatus.NO_CONTENT);
	}
	@ApiOperation(value="사용자의 모든 할일목록을 삭제한다.", response=List.class)
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<Result> deleteTodoList(@PathVariable String userId) {
		boolean flag = todoService.removeTodoList(userId);
		if (flag) {
			return new ResponseEntity<Result>(new Result(true, userId+"의 todoList가 삭제되었습니다." ), HttpStatus.OK);
		}
		return new ResponseEntity<Result>(new Result(false, userId+"의 todoList 삭제에 실패하였습니다."), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ApiOperation(value="등록되어 있는 할일을 완료 처리한다.", response=Result.class)
	@PutMapping("/todo/done/{no}")
	public ResponseEntity<Result> completeTodo(@PathVariable int no) {
		boolean flag = todoService.completeTodo(no);
		if (flag) {
			return new ResponseEntity<Result>(new Result(true, "todo가 완료 처리되었습니다. : " + no), HttpStatus.OK);
		}
		return new ResponseEntity<Result>(new Result(false, "todo 완료처리에 실패하였습니다."), HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
