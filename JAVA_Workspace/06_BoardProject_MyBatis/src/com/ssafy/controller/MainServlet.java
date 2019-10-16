package com.ssafy.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.PageBean;
import com.ssafy.model.service.BoardService;
import com.ssafy.model.service.BoardServiceImpl;
import com.ssafy.model.service.MemberService;
import com.ssafy.model.service.MemberServiceImp;

@WebServlet({ "*.do", "*.log" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImpl();
	private MemberService memberService = new MemberServiceImp();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp";
		String action = request.getServletPath();
		System.out.println("action: " + action);

		try {
			if (action != null) {
				// TODO: 04 loginform.do가 호출될 때 member/login.jsp를 연결하시오.
				if(action.endsWith("loginform.do")) {
					url ="/member/login.jsp";
				}
				// END:

				// TODO: 05 login.do 가 호출될 때 동작할 login()를 호출하시오.
				else if(action.endsWith("login.do")){
					url = login(request, response);
				}
				// END:

				// TODO: 06 logout.log 호출 시 동작할 logout()를 호출하시오.
				// END:
				else if(action.endsWith("logout.do")){
					url = logout(request, response);
				}
				// TODO: 07 insertMemberForm.do 호출 시 /member/insertMember.jsp로 이동하시오.
				// END:

				// TODO: 08 insertMember.do 호출 시 동작할 insertMember()를 호출하시오.
				// END:

				// TODO: 09 memberUpdateForm.log 호출 시 동작할 memberUpdateForm()을 호출하시오.
				// END:
				else if(action.endsWith("memberUpdateForm.log")) {
				// TODO: 10 updateMember.log 호출 시 동작할 updateMember()를 호출하시오.
					url = memberUpdateForm(request, response);
				}
				// END:

				// TODO: 11 listBoard.do 호출 시 /board/listBoard.jsp로 이동한다.
				else if(action.endsWith("listBoard.do")||action.endsWith("main.do")) {
					// TODO: 10 updateMember.log 호출 시 동작할 updateMember()를 호출하시오.
					url = listBoard(request, response);
				}
				// END:

				// TODO: 12-1 searchBoardAjax.do 호출 시 동작할 searchBoardAjax()를 구현하시오.
				else if(action.endsWith("searchBoardAjax.do")) {
					// TODO: 10 updateMember.log 호출 시 동작할 updateMember()를 호출하시오.
					url = searchBoardAjax(request, response);
				}
				
				// END:

				// TODO: 13 searchBoard.do 호출시 동작할 searchBoard()를 구현하시오.
				else if(action.endsWith("searchBoard.do")) {
					// TODO: 10 updateMember.log 호출 시 동작할 updateMember()를 호출하시오.
					url = searchBoard(request, response);
				}
				// END:

				// TODDO: 14 deleteBoard.do 호출 시 동작할 deleteBoard를 구현하시오.
				else if (action.endsWith("deleteBoard.do")) {
//					url = deleteBoard(request, response);
				} //else
				// END:
				// END:

				// TODO: 15 updateBoardForm.do 호출 시 동작할  boardUpdateForm()을 구현하시오.
				// END:

				// TODO: 16 updateBoard.do 호출 시 동작할 updateBoard()를 구현하시오.
				// END:

				// TODO: 17 insertBoardForm.do 호출 시 /board/insertBoard.jsp로 이동하시오.
				else if(action.endsWith("insertBoardForm.log")) {
					// TODO: 10 updateMember.log 호출 시 동작할 updateMember()를 호출하시오.
					url ="/board/insertBoard.jsp";
				}
				// END:

				// TODO: 18 insertBoard.log 호출 시 동작할 insertBoard()를 구현하고 호출하시오.
				else if(action.endsWith("insertBoard.log")) {
					// TODO: 10 updateMember.log 호출 시 동작할 updateMember()를 호출하시오.
					url =insertBoard(request, response);
				}
				// END:
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			url = "ErrorHandler.jsp";
		}
		// TODO: 02 url이 {로 시작할 경우 ajax로, redirect로 시작할 경우 redirect로, 나머지는 forward로 처리하시오.
		if(url.startsWith("{")) {
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().append(url);
		}else if(url.startsWith("redirect")) {
			response.sendRedirect(url.substring(url.indexOf(":")+1));
		}else {
			request.getRequestDispatcher(url).forward(request, response);
		}
		// END:
	}

	// TODO: 05-1 login을 통해 로그인 처리하시오. 주요 사항은 아래를 참조한다.
	// @@ 아이디 저장 기능을 사용할 경우 id를 이름으로 쿠키를 저장한다.
	// @@ memberService의 login을 이용해 로그인 하고 성공 시 referer가 있을 경우는 referer로, 그렇지 않을 경우 index.jsp로 이동한다.
	// @@ 로그인 실패 시 msg를 키로 request에 실패 사유를 저장하고 loginform.do로 이동한다.
	private String login(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String password =  request.getParameter("pw");
		String idSave = request.getParameter("idsave");
		String referer = request.getParameter("referer");
		
		Cookie cookie = new Cookie("id",id);
		if(idSave !=null) {
			cookie.setMaxAge(100000000);
		}else {
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		try {
			memberService.login(id, password);
			addToSession(request,"id",id);
			if(referer!=null) {
				return referer;
			}else {
				return "redirect:index.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "loginform.do";
		}
	}
	// END:

	// TODO: 06-1 logout()을 통해 로그아웃 처리하시오.
	// @@ 세션에서 사용자 정보(id)를 제거하고 loginform.do로 이동한다.
	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession  session = request.getSession();
		session.invalidate();
		return "redirect:loginform.do";
	}
	// END:

	// TODO: 08-1 insertMember()를 통해 회원가입을 처리하시오.
	// @@ 가입 성공 시 loginform.do로 이동해서 로그인을 유도하고 실패 시 오류 메시지를 설정하고 다시 현재 페이지를 호출한다.
	// END:

	// TODO: 09-1 memberUpdateForm()을 통해 회원 정보 수정 페이지를 보이시오.
	// @@ 이때 현재 login 되어있는 사용자 정보를 화면 /member/updateMember.jsp에 전달한다.
	private String memberUpdateForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id= getId(request);
		request.setAttribute("member", memberService.search(id));
		return "member/updateMember.jsp";
	}
	// END:

	// TODO: 10-1 updateMember()를 통해 회원 정보를 수정하시오.
	// @@ 수정 성공 시 index.jsp로 이동하고 실패 시 오류 메시지를 설정하고 다시 현재 페이지를 호출한다.
	// END:

	private String listBoard(HttpServletRequest request, HttpServletResponse response) {
		String key= request.getParameter("key");		//조회 조건
		String word= request.getParameter("word");		//검색할 단어
		String pageNo= request.getParameter("pageNumber");	//현재 페이지 번호
		
		PageBean bean = new PageBean(key, word, pageNo);
		System.out.println(bean);
		request.setAttribute("bean", bean);
		request.setAttribute("list", boardService.searchAll(bean));
		return "/board/listBoard.jsp";
	}
	
	// TODO: 12-2 searchBoardAjax()를 통해 게시글을 JSON 문자열 형태로 반환한다.
	// @@ boardService.search(no)을 호출하자.
	private String searchBoardAjax(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("no");
		System.out.println("searchBoardAjax.........no:"+no);
		Board board = boardService.search(no);
		Gson gson = new Gson();
		return gson.toJson(board);
	}
	// END:

	// TODO: 13-1 searchBoard()를 구현해서 게시물 상세 내용을 출력하시오.
	private String searchBoard(HttpServletRequest request, HttpServletResponse response) {
		String no = request.getParameter("no");
		request.setAttribute("board", boardService.search(no));
		return "/board/searchBoard.jsp";
	}

	// END:

	// TODO: 14-1 deleteBoard()를 구현해서 게시물을 삭제 처리하시오.
	// END:

	// TODO: 15-1 boardUpdateForm() 을 구현해서 게시물 수정 화면인 /board/updateBoard.jsp를 리턴한다.
	// @@ no에 해당하는 게시물을 검색해서 board라는 이름으로 저장한다.
	// END:

	// TODO: 16-1 updateBoard() 구현해서 게시물을 수정 처리하시오.
	// @@ 수정 성공 시 listBoard.do로 이동하고 실패 시 updateBoardForm.do로 이동하시오.
	// END:

	// TODO: 18-1 insertBoard()를 구현해서 게시글 정보를 저장하시오.
	private String insertBoard(HttpServletRequest request, HttpServletResponse response) {
		String id = getId(request);
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		Board board = new Board(id, title, contents);
		boardService.insertBoard(board);
		return  "redirect:listBoard.do";
	}
	// END:

	public void addToSession(HttpServletRequest request, String key, Object value) {
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}

	public String getId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (String) session.getAttribute("id");
	}
}
