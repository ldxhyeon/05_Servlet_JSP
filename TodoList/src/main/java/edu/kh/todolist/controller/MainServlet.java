package edu.kh.todolist.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// "/" 요청을 매핑하여 처리하는 서블릿
// "/" == localhost/ ==  메인페이지

@WebServlet("/")
public class MainServlet extends HttpServlet{

	/* 왜 "/" 메인페이지 요청을 처리하는 서블릿 만들었는가 ??
	 * - Servlet(Back-end)에서 추가한 데이터를 
	 * 메인 페이지에서 사용할 수 있게 하려고         
	 * 
	 */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 테스트용 샘플 데이터
		// str 키 값을 찾아 값 Set 하기
		// req.s etAttribute("str", "메인 페이지 요청 시 값 전달됨");
		
		
		
		// 처리할 경로 정하기
		String path = "/WEB-INF/views/main.jsp";
		
		// 경로에 응답과 요청 위임
		req.getRequestDispatcher(path).forward(req, resp);
		
		
		
		
	}
}
