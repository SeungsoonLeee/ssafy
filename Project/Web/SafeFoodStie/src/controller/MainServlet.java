package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.Food;
import model.dto.Member;
import service.FoodServiceImp;
import service.MemberServiceImp;

@WebServlet("*.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberServiceImp memberService = new MemberServiceImp();
	private FoodServiceImp foodService = new FoodServiceImp();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "index.jsp";
		String action = request.getServletPath();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			if (action != null) {
				if (action.endsWith("saveDataToDB")) {
					url = saveDataToDB(request, response);
				} else if (action.endsWith("login.do")) {
					url = login(request, response);
				} else if (action.endsWith("logout.do")) {
					url = logout(request, response);
				} else if (action.endsWith("RegisterGo.do")) {
					goRegister(request, response);
				} else if (action.endsWith("Register.do")) {
					url = Register(request, response);
				} else if (action.endsWith("memberInfoGo.do")) {
					goMemberInfo(request, response);
				} else if (action.endsWith("foodList.do")) {
					foodList(request, response);
				} else if (action.endsWith("foodDetail.do")) {
					foodDetail(request, response);
				} else if (action.endsWith("memberUpdate.do")) {
					url = memberUpdate(request, response);
				} else if (action.endsWith("memberRemove.do")) {
					url = memberRemove(request, response);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			url = "ErrorHandler.jsp";
		}
		if (url.startsWith("redirect")) {
			response.sendRedirect(url.substring(url.indexOf(":") + 1));
		} else {
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

	private String memberRemove(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	private String memberUpdate(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("왔다");
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		String name = request.getParameter("name");
		System.out.println(id);
		String email = request.getParameter("email");
		String phone = request.getParameter("tel");
		String address = request.getParameter("addr");
		String allergy = "";
		String[] allergies = request.getParameterValues("allergies");
		if (allergies != null) {
			allergy = allergies[0];
			for (int i = 1; i < allergies.length; i++) {
				allergy += ("," + allergies[i]);

			}
		}
		System.out.println(allergy);
		try {
			memberService.update(new Member(id, password, name, email, phone, address, allergy));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		} finally {
			return "index.jsp";
		}
	}

	private void foodDetail(HttpServletRequest request, HttpServletResponse response) {
		int code = Integer.parseInt((String) request.getParameter("foodcode"));
		Food food = foodService.search(code);
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		String allergies;
		if(member != null) {
			allergies = memberService.getAllergyIngredients(food, member.getAllergy());
		} else {
			allergies = "";
		}
		request.setAttribute("allergyIngredients", allergies);
		request.setAttribute("food", food);
		request.setAttribute("content", "detailList.jsp");
	}
	private class foodSortComparator implements Comparator<Food>{
		String sortKey;
		public foodSortComparator(String sortKey) {
			this.sortKey = sortKey;
		}
		@Override
		public int compare(Food o1, Food o2) {
			int res = 0;
			//브랜드 명으로 정렬
			if(sortKey.equals("sortMaker")) {
				res = o1.getMaker().compareTo(o2.getMaker());
			}
			//기본 형은 이름순으로 정렬
			else { //if(sortKey.equals("name")) {
				res = o1.getName().compareTo(o2.getName());
			}
			return res;
		}
	};
	private void foodList(HttpServletRequest request, HttpServletResponse response) {
		List<Food> list;
		try {
			String key = request.getParameter("searchOption");
			String value = request.getParameter("searchItem");
			String sortKey = request.getParameter("sortOption");
			if (key == null && value == null && sortKey == null) {
				key = "searchName";
				value = "";
				sortKey = "sortName";
			}
			list = foodService.searchAll(key, value);
			
			Collections.sort(list, new foodSortComparator(sortKey));
			request.setAttribute("list", list);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			list = null;
		} finally {
			request.setAttribute("content", "main.jsp");
		}
	}

	private String Register(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("tel");
		String address = request.getParameter("addr");
		String allergy = "";
		String[] allergies = request.getParameterValues("allergies");

		if (allergies != null) {
			allergy = allergies[0];
			for (int i = 1; i < allergies.length; ++i) {
				allergy += ("," + allergies[i]);
			}
		}

		try {
			memberService.add(new Member(id, password, name, email, phone, address, allergy));
			return "redirect:index.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "redirect:Registergo.do";
		}
	}

	private String saveDataToDB(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("foodList"));
		return null;
	}

	protected String cookieTest(HttpServletRequest request, HttpServletResponse response) {
		// 쿠키 생성
		String cookieName = request.getParameter("cookiename");
		String cookieValue = request.getParameter("cookievalue");
		Cookie cookie = new Cookie(cookieName, cookieValue);

		// 음수 : 메모리에만 저장 -> 브라우저 종료 시 쿠키 삭제
		cookie.setMaxAge(0);

		// 쿠키 발생
		response.addCookie(cookie);

		return "redirect:CookieTest.jsp";
	}

	protected String login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String idSave = request.getParameter("idsave");
		String referer = request.getParameter("referer");

		Cookie cookie = new Cookie("id", id);
		if (idSave != null) {
			cookie.setMaxAge(-1);
		} else {
			cookie.setMaxAge(0);
		}

		response.addCookie(cookie);

		try {
			memberService.login(id, pw);
			Member m = memberService.search(id);
			addToSession(request, "member", m);
			if (referer != null) {
				return referer;
			} else {
				return "redirect:index.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "index.jsp";
		}
	}

	protected void addToSession(HttpServletRequest request, String key, Object value) {
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}

	protected String getId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (String) session.getAttribute("id");
	}

	protected String logout(HttpServletRequest request, HttpServletResponse response) {
		String referer = request.getParameter("referer");

		System.out.println(referer);
		HttpSession session = request.getSession();
		session.invalidate();

		if (referer != null) {
			return referer;
		} else {
			return "redirect:index.jsp";
		}
	}

	protected String inputBasket(HttpServletRequest request, HttpServletResponse response) {
//		int no = Integer.parseInt(request.getParameter("no"));
//		String proname = request.getParameter("proname");
//		int proprice = Integer.parseInt(request.getParameter("proprice"));
//		int quantity = Integer.parseInt(request.getParameter("quantity"));
//		Goods g = new Goods(no, proname, proprice, quantity, 0);
//		
//		HttpSession session = request.getSession();
//		HashMap<Integer, Goods> cart1 = (HashMap<Integer, Goods>) session.getAttribute("cart1");
//		
//		if (cart1 == null) {
//			cart1 = new HashMap<Integer, Goods>();
//			session.setAttribute("cart1", cart1);
//		}
//		
//		Goods findG = cart1.get(no);
//		if(findG != null) {
//			// 레퍼런스로 가져왔기 때문에 수량 수정 후 해쉬에 다시 넣어주지 않아도 됨
//			findG.setQuantity(findG.getQuantity() + quantity);
//		}else {
//			cart1.put(no, g);
//		}
//		
//		System.out.println(cart1);
//		
		return "redirect:goodsList.do";
	}

	private void goMemberInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
			Member m = memberService.search(getId(request));
			request.setAttribute("member", m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("content", "Modify.jsp");
	}

	private void goRegister(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("content", "Register.jsp");
	}
}
