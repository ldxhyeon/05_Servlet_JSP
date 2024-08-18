package edu.kh.worklist.controller;

import java.io.IOException;

import edu.kh.worklist.dto.Work;
import edu.kh.worklist.service.WorkListService;
import edu.kh.worklist.service.WorkListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/work/detail")
public class DetailServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int index = Integer.parseInt(req.getParameter("index"));
			
			WorkListService service = new WorkListServiceImpl();
			
			Work work = service.workDetailView(index);
			
			if(work == null) {
				HttpSession session = req.getSession();
				session.setAttribute("message", "해당 index에 할 일이 존재하지 않습니다.");
				
				resp.sendRedirect("/");
				return;
			}
			
			req.setAttribute("work", work);
			
			String path = "/WEB-INF/views/detail.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
