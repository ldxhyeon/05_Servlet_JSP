package edu.kh.worklist.controller;

import java.io.IOException;

import edu.kh.worklist.service.WorkListService;
import edu.kh.worklist.service.WorkListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/work/complete")
public class CompleteServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int index = Integer.parseInt(req.getParameter("index"));
		
		try {
			
			WorkListService service = new WorkListServiceImpl();
			boolean result = service.workComplete(index);
			
			HttpSession session = req.getSession();
			
			if(result) {
				
				session.setAttribute("message", "완료 여부가 변경 되었습니다.");
				// 해당 인덱스 상세페이지로 이동
				resp.sendRedirect("/work/detail?index=" + index);
				return;
			}
			
			session.setAttribute("message", "헤당 index번째 work가 존재하지 않습니다.");
			resp.sendRedirect("/");
					
			
		} catch(Exception e) {
			
		}
	}
	
	

}
