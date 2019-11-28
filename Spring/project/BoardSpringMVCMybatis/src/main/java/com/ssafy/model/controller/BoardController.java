package com.ssafy.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.model.dto.PageBean;
import com.ssafy.model.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;

	@GetMapping("listBoard.do")
	public String listBoard(PageBean bean, Model model) {
		model.addAttribute("list", service.searchAll(bean));
		return "board/listBoard";
	}
	
	@GetMapping("searchBoard.do")
	public String searchBoard(String no, Model model) {
		model.addAttribute("board", service.search(no));
		return "board/searchBoard";
	}
	
	@GetMapping("updateBoard.do")
	public String updateBoard(PageBean bean, Model model) {
		model.addAttribute("list", service.searchAll(bean));
		return "board/listBoard";
	}
	
	@GetMapping("deleteBoard.do")
	public String deleteBoard(PageBean bean, Model model) {
		model.addAttribute("list", service.searchAll(bean));
		return "board/listBoard";
	}
}
