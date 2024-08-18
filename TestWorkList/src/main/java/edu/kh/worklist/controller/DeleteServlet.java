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

@WebServlet("/work/delete")
public class DeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int index = Integer.parseInt(req.getParameter("index"));
			
			WorkListService service = new WorkListServiceImpl();
			
			String title = service.todoDelete(index);
			
			HttpSession session = req.getSession();
			
			String result = null;
			
			if(title != null) result = title + "할 일이 삭제 되었습니다.";
			else 			  result = "해당 index번째 work가 존재하지 않습니다.";
			
			session.setAttribute("result", result);
			
			resp.sendRedirect("/");
					
					
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
