package com.ssafy.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.pms.Member;
import com.ssafy.pms.Phone;
import com.ssafy.service.PhoneServiceImpl;
import com.ssafy.service.memberServiceImpl;

@Controller
public class MainController {
	@Autowired
	private PhoneServiceImpl service;
	@Autowired
	private memberServiceImpl Mservice;

	@ExceptionHandler
	public ModelAndView exceptionHandler(Exception e) {
		ModelAndView mav = new ModelAndView("Error");
		mav.addObject("msg", e.getMessage());
		return mav;
	}

	@PostMapping("phoneInsert.do")
	public String phoneInsert(Phone phone) {
		service.insert(phone);
		return "redirect:result.do";
	}

	@GetMapping("result.do")
	public String result(Phone phone) {
		return "result";
	}

	@GetMapping("phoneInsertForm.do")
	public String phoneInsertForm() {
		return "PhoneReg";
	}

	@GetMapping("phoneList.do")
	public String phoneList(Model model) {
		model.addAttribute("list", service.searchAll());
		return "PhoneList";
	}

	@GetMapping("phoneView.do")
	public String phoneView(Model model, String num) {
		model.addAttribute("phone", service.search(num));
		return "PhoneView";
	}

	@GetMapping("phoneDelete.do")
	public String phoneDelete(String num) {
		service.delete(num);
		return "redirect:phoneList.do";
	}

	@GetMapping("phoneDelete2.do")
	public String phoneDelete2(@RequestParam List<String> num) {
		service.delete2(num);
		;
		return "redirect:phoneList.do";
	}

	@GetMapping("main.do")
	public String main(String num) {
		service.delete(num);
		return "index";
	}

	@PostMapping("login.do")
	public String login(String id, String pw, HttpSession session) {
		boolean result = Mservice.login(id, pw);
		if (result) {
			session.setAttribute("id", id);
		}
		return "redirect:index.jsp";
	}
	
	@GetMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index.jsp";
	}
}
