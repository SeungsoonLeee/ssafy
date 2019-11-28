package com.ssafy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.model.dto.FAQ;
import com.ssafy.model.service.FAQService;

@Controller
public class FAQController {
	@Autowired
	private FAQService service;

	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("ErrorHandler");
		mav.addObject("msg", e.getMessage());
		return mav;
	}

	@GetMapping("faqInput.do")
	public String faqInput() {
		return "faq/FAQInsert";
	}

	@PostMapping("faqInsert.do")
	public String faqInsert(FAQ faq) {
		service.insert(faq);
		return "redirect:faqList.do";
	}

	@GetMapping("faqList.do")
	public String faqList(Model model) {
		model.addAttribute("list", service.searchAll());
		return "faq/FAQList";
	}

	@GetMapping("faqSearch.do")
	public String faqSearch(Model model, String no) {
		model.addAttribute("faq", service.search(no));
		return "faq/FAQSearch";
	}

	@GetMapping("faqDelete.do")
	public String faqDelete(String no) {
		service.delete(no);
		return "redirect:faqList.do";
	}

	@GetMapping("faqUpdateForm.do")
	public String faqUpdateForm(String no, Model model) {
		model.addAttribute("faq", service.search(no));
		return "faq/FAQUpdate";
	}

	@PostMapping("faqUpdate.do")
	public String faqUpdate(FAQ faq) {
		service.update(faq);
		return "redirect:faqSearch.do?no=" + faq.getNo();
	}

	@PostMapping("faqReply.do")
	public String faqReply(FAQ faq) {
		service.reply(faq);
		return "redirect:FAQList.do";
	}

}
