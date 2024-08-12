package edu.kh.practice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 클라이언트가 search 경로로 들어왔을때
@WebServlet("/search")
public class PracticeServlet extends HttpServlet{
	
//	// 리스트 생성
//	private List<String> nameList = null;
//	
//	
//	public PracticeServlet() { // 기본 생성자
//		
//		// 리스트가 null에서 객체 생성
//		nameList = new ArrayList<String>();
//		
//		nameList.add("일동현");
//		nameList.add("이동현");
//		nameList.add("삼동현");
//		nameList.add("사동현");
//		nameList.add("오동현");
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		// 제출된 파라미터 얻어오기
//		String inputName = req.getParameter("inputName");
//		
//		// 입력된 이름이 nameList에 있는지 없는지 확인
//		// int List.indexOf("값") : 값과 일치하는 요소의 index 반환
//		//							없으면 -1 반환
//		int index = nameList.indexOf(inputName);
//		
//		// 존재하는 경우
//		if(index > -1) {
//			String message = String.format("%s님은 %d번째 인덱스에 존재합니다.",
//								inputName, index);
//			
//			
//			req.setAttribute("message", message);
//			
//			// JSP 파일 경로를 webapp 폴더 기준으로 작성
//			// -WEB-INF 폴더는 클라이언트 직접 접근 불가
//			// 하지만 서버는 가능
//			String path = "/WEB-INF/views/result.jsp";
//			
//			
//			// 지정된 경로의 jsp에게 응답을 대신하라고 위임(forward)
//			// 이 때, 기존 req/resp가 유지됨
//			// 응답화면의 주소 : /search
//			// (현재 Servlet 매핑 주소)
//			req.getRequestDispatcher(path).forward(req, resp);
//			
//		}
//		
//		// 존재하지 않은 경우
//		else {
//			// Session scope 객체 얻어오기
//			HttpSession session = req.getSession();
//			
//			session.setAttribute("message", inputName + "님은 존재하지 않습니다.");
//			
//			// 왜 message를 session scope에 세팅했을까?
//			// -> redirect(재요청)시
//			// 기존 req/resp 객체가 사라지고
//			// 새 req/resp 객체가 생성되기 때문에
//			
//			// 기존 req에 값을 세팅해봐야 없어지기 때문에 의미 없음
//			
//			// 메인 페이지(/) 재요청하기
//			// -> webapp 폴더 기준으로 파일 경로 작성
//			// 또는 원하는 Servlet의 매핑되는 주소 작성
//			resp.sendRedirect("/");
//		}
//		
//		
//	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<String> list = new ArrayList<String>();
		
		list.add("일동현");
		list.add("이동현");
		list.add("삼동현");
		list.add("사동현");
		list.add("오동현");
		
		// 값 얻어오기
		String inputName = req.getParameter("inputName");
		
		// 입력된 값이 리스트에 있는지 없는지 확인
		// 없다면 -1 반환
		int index = list.indexOf(inputName);
		
		
		if(index > -1) {
			String message = String.format("%s님은 %d번째에 존재합니다.",inputName, index );
			
			req.setAttribute("message", message);
			
			String path = "/WEB-INF/views/result.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		}
		
		else {
			HttpSession session = req.getSession();
			 session.setAttribute("message", inputName + "님은 존재하지 않습니다.");
			 
			 resp.sendRedirect("/");
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
