package com.ssafy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.dto.Board;

@Controller // annotation으로 controller 설정
public class MainController {
	
	/**
	 * 1. mapping
	 *	요청 url에 따른 처리할 controller method를 mapping 시킨다.
	 * 		@RequestMapping("url", method=RequestMethod.XXX)
	 * 			- method : 요청방식, 어떤 방식으로 요청하던 모두 처리함
	 * 			- value : 요청 url, 다른 속성이 없으면 생략 가능
	 * 				<형식>
	 * 				value = "url"
	 * 				value = "{url, ...}"
	 * 		
	 * 		Spring 4.x 에 추가된 @ -> pom.xml에서 spring version을 변경하면 됨
	 * 			@GetMapping("url") : get 방식 요청 처리
	 * 			@PostMapping("url") : post 방식 요청 처리
	 * 
	 * 2. 인자
	 *  요청 데이터
	 *   	2.1. String
	 *   		- 인자명으로 요청 데이터를 추출하여 전달
	 *   		ex)
	 *   		String msg;
	 *   		String msg = request.getParameter("msg");
	 *   		- 인자명에 해당하는 요청데이터가 요청 패킷에 없어도, 요청 데이터명은 있지만 데이터가 없어도 error가 발생하지 않음.
	 *   
	 *   	2.2. Primitive
	 *   		- 인자명으로 요청 데이터를 추출하여 해당 format으로 변경 후 전달
	 *   		ex)
	 *   		int num;
	 *   		num = Integer.parseInt(request.getParameter("num"));
	 *   		- 인자명에 해당하는 요청데이터가 요청 패킷에 없으면 500, 요청 데이터명은 있지만 데이터 format이 다르면 400 error가 발생.
	 *   
	 *   	2.3. @RequestParam
	 *   		- String or Primitive
	 *   		ex)
	 *   		@RequestParam(value="요청 데이터명", required, defaultValue)
	 *   			- value : 추출할 요청 데이터명
	 *   			- required
	 *   				- true : 요청 데이터가 없는 경우 error
	 *   			- defaultValue : 요청 데이터가 없는 경우 지정한 값으로 전달
	 *   
	 *   	2.4. DTO(Data Transfer Object)
	 *   		- 인자의 객체를 기본 생성자로 생성
	 *   		- 객체의 모든 속성을 요청 패킷에서 데이터를 추출하여 setter 메서드를 이용하여 데이터를 설정
	 *   		- 첫글자를 소문자로 한 클래스명으로 request에 저장
	 *   		ex)
	 *   		Board b = new Board();
	 *   		b.setNo(Integer.parseInt(request.getParameter("no")));
	 *   		b.setId(request.getParameter("id"));
	 *   		b.setTitle(request.getParameter("title"));
	 *   		b.setRegDate(request.getParameter("regdate"));
	 *   		b.setContents(request.getParameter("contents"));
	 *   		request.setAtrribute("board", b);
	 *   
	 *   	2.5. @ModelAttribute("이름") DTO
	 *   		- 인자의 객체를 기본 생성자로 생성
	 *   		- 객체의 모든 속성을 요청 패킷에서 데이터를 추출하여 setter 메서드를 이용하여 데이터를 설정
	 *   		- 지정한 이름으로 request에 저장
	 *   
	 *   	2.6. @RequestParam Map
	 *   		- 요청 패킷에서 모든 요청 데이터를 추출하여 map에 요청데이터명:key, 요청데이터:value 로 설정
	 *   		- request에 저정하지는 않음
	 *   
	 *   	2.7. Servlet API를 인자로
	 *   		- HttpServletRequest, HttpServletResponse, HttpSession, Reader, Writer, ServletInputStream, ServletOutputStream
	 *   		- Servlet module이 3.0 이상 일 때에만 ServletContext를 인자로 받을 수 있음
	 *   
	 *   	2.8. Model을 인자로 
	 *   		- Model은 interface이므로 인자로만 받을 수 있음
	 *   		- Service를 수행한 결과를 Model에 저장하면 request에 반영됨
	 *   		
	 *   	2.9. MultipartFile
	 *   		- 업로드된 파일 정보
	 *   		- pom.xml 에 파일과 관련된 라이브러리를 추가하여야 함
	 *   			commons-io-xxx(version).jar
	 *   			commons-fileupload-xxx(version).jar
	 *   		- web을 위한 bean configuration에 multipartResolver를 추가 하여야 함
	 *   			multipartResolver : 요청 데이터에서 파일 정보반 추출하여 MultipartFile로 전달
	 *   
	 * 3. 리턴
	 * 	View에 대한 정보
	 * 		3.1. String
	 * 			- 이동할 View에 대한 url을 문자열로
	 * 				- forward : "url" or "forward:url"
	 *   			- redirect : "redirect:url"
	 *   
	 *   	3.2. void
	 *   		- 요청 url에서 '.'이후를 제거한 이름을 view로 인식하여 등록된 이름의 view로 이동
	 *   		- ViewResolver를 설정하여 View 이름을 지정해야 함
	 *   		ex)
	 *   		@PostMapping("insertBoard.log") 인 경우, View 이름은 inserBoard
	 *   
	 *   	3.3. DTO or Map or 집합객체(배열, 컬렉션)
	 *   		- REST Full service : 서비스에서 전달할 데이터를 XML이나 JSON 형태로 하여 전달함으로써
	 *   							  web외의  android 등에서도 xml, json을 파싱하여 view를 뿌릴 수 있다. 따라서 서버를 하나만 운영할 수 있게 된다.
	 *   		- XML이나 JSON 데이터로 출력
	 *   		- jackson-bind-xxx.jar 사용 => 리턴 정보를 json으로 출력해주는 라이브러리
	 *   		- @ResponseBody 추가해야 함
	 *   
	 *   	3.4. ModelAndView
	 *   		- model을 수행한 결과 정보와 view 정보를 표현하는 객체
	 *   		- 잘 사용하지 않으나 예외처리를 위한 용도로 쓰임
	 * 
	 *  4. 예외 처리
	 *   현재 컨트롤러에서 발생한 오류를 처리
	 *   ex)
	 *   @ExceptionHandler
	 *   public 리턴타입 함수명(Exception e){
	 *   	. . .
	 *   }
	 *  
	 *  
	 */			
	
	
	// 1. mapping 예제
//	@RequestMapping("hello.do") // 요청 url
//	@GetMapping("hello.do")
//	public String hello() {
//		return "hello.jsp"; // forward로 이동
//		return "redirect:hello.jsp"; // redirect로 이동
//	}

	
	// 2.1. String 인자를 받는 예제
//	@GetMapping("hello.do")
//	public String hello(String msg) {
//		System.out.println("msg : " + msg);
//		return "hello.jsp"; // forward로 이동
//	}
	
	
	// 2.2. Primitive 인자를 받는 예제
//	@GetMapping("hello.do")
//	public String hello(int msg) {
//		System.out.println("msg : " + msg);
//		return "hello.jsp"; // forward로 이동
//	}
	
	
	// 2.3. @RequestParam
//	@GetMapping("hello.do")
//	public String hello(@RequestParam(required = true) String msg) {
//		// 인자명에 요청 데이터가 없으면 error(400)
//		System.out.println("msg : " + msg);
//		return "hello.jsp"; // forward로 이동
//	}
	
	
	// 2.3. @RequestParam
//	@GetMapping("hello.do")
//	public String hello(@RequestParam(defaultValue = "5000") String msg) {
//		// 인자명에 요청 데이터가 없거나 비어있어도 default 값으로 전달, 하지만 format이 다른 경우엔 error
//		System.out.println("msg : " + msg);
//		return "hello.jsp"; // forward로 이동
//	}
	
	
	// 2.4. DTO 인자를 받는 예제
//	@PostMapping("insertBoard.log")
//	public String insertBoard(Board b) {
//		System.out.println(b);
//		return "result1.jsp"; // forward로 이동
//	}
	
	
	// 2.5. @ModelAttribute("이름") 예제
//	@PostMapping("insertBoard.log")
//	public String insertBoard(@ModelAttribute ("b") Board board) {
//		System.out.println(board);
//		return "result2.jsp"; // forward로 이동
//	}
	
	
	// 2.6, 2.7 @RequestParam Map, Servlet API 예제
//	@PostMapping("insertBoard.log")
//	public String insertBoard(HttpServletRequest request,  @RequestParam Map<String, String> map) {
//		System.out.println(map);
//		request.setAttribute("board", map);
//		return "result1.jsp"; // forward로 이동
//	}
	
	
	// 2.6, 2.8 @RequestParam Map, Model 예제
//	@PostMapping("insertBoard.log")
//	public String insertBoard(Model model, @RequestParam Map<String, String> map) {
//		System.out.println(map);
//		model.addAttribute("board", map);
//		return "result1.jsp"; // forward로 이동
//	}
	
	
	// 3.2 리턴을 void로 하는 예제
	// InternalResourceViewResolver를 설정해야 함
//	@GetMapping("showMessage.do")
//	public void showMessage(String msg, Model model) {
//		model.addAttribute("message", msg);
//	}
	
	// 3.3 DTO 리턴하는 예제
	@GetMapping("rest.do")
	@ResponseBody
	public Board rest() {
		return new Board("ssafy", "처음하는", "spring");
	}
	
	// 3.3 DTO 컬렉션으로 리턴하는 예제
	@GetMapping("rests.do")
	@ResponseBody
	public List<Board> rests() {
		ArrayList<Board> boards = new ArrayList<Board>();
		boards.add(new Board("ssafy", "처음하는11", "spring111"));
		boards.add(new Board("ssafy", "처음하는22", "spring222"));
		return boards;
	}
	
	// 4. 예외처리 예제
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("ErrorHandler.jsp");
		mav.addObject("msg", e.getMessage());
		return mav;
	}
	@GetMapping("error.do")
	public String error() {
		System.out.println(256 / 0);
		return "result1.jsp";
	}

}
