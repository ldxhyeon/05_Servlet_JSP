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

@WebServlet("/work/add")
public class WorkAddServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			WorkListService service = new WorkListServiceImpl();
			
			// 요청할때 전달 받은 파라미터
			String title = req.getParameter("title");
			String detail = req.getParameter("detail");
			
			int index = service.workAdd(title, detail);
			
			String message = null;
			if(index > -1) message = "추가 성공!";
			else		   message = "추가 실패!";
			
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			resp.sendRedirect("/");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
