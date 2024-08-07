package edu.kh.jsp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 사용자가 jstl2로 접근하면 밑에 코드 실행
@WebServlet("/el_jstl2")
public class JstlSignup extends HttpServlet {
	
		@Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 	// 1. 요청이 들어오면, 처리할 JSP 파일의 경로를 설정합니다.
	        String path = "/WEB-INF/views/el_jstl2.jsp";
	        
	        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
	        
	        dispatcher.forward(req, resp);
	    }
	

	 // 사용자가 jstl2로 접근해서 회원가입 양식
	 // 제출하면 POST로 데이터를 보내
	 // 밑에 메서드 실행
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
	        // 폼 데이터 가져오기
	        String id = req.getParameter("inputId");
	        String pw = req.getParameter("inputPw");
	        String pwCheck = req.getParameter("inputPwCheck");
	        String name = req.getParameter("inputName");
	        String age = req.getParameter("inputAge");

	        // 가져온 데이터를 req 객체에 속성으로 저장
	        req.setAttribute("id", id);
	        req.setAttribute("pw", pw);
	        req.setAttribute("pwCheck", pwCheck);
	        req.setAttribute("name", name);
	        req.setAttribute("age", age);

	        String path = "/WEB-INF/views/el_jstl3.jsp";
	        
	        // 요청과 응답을 처리할 경로를 정하는 코드
	        RequestDispatcher dispatcher = req.getRequestDispatcher(path);
	        // 그 경로로 요청과 응답을 전달
	        dispatcher.forward(req, resp);
	    }
}
