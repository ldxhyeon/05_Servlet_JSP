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

@WebServlet("/work/update")
public class UpdateServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int index = Integer.parseInt(req.getParameter("index"));
		
		try {
			
			WorkListService service = new WorkListServiceImpl();
			Work work = service.workDetailView(index);
			
			req.setAttribute("work", work);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String path = "/WEB-INF/views/update.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 제목
		String title = req.getParameter("title");
		// 상세 내용
		String detail = req.getParameter("detail");
		
		int index = Integer.parseInt(req.getParameter("index"));
		
		
		
		try {
			WorkListService service = new WorkListServiceImpl();
			
			boolean result = service.workUpdate(index, title, detail);
			
			String url = null;
			String message = null;
			
			if(result) {
				url = "/work/detail?index=" + index;
				message = "수정 되었습니다.";
			}else {
				url = "/work/udate?index=" + index;
				message = "수정 실패.";
			}
			
			req.getSession().setAttribute("message", message);
			
			resp.sendRedirect(url);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
				
		
	}

}
