package edu.kh.worklist.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.kh.worklist.dto.Work;
import edu.kh.worklist.service.WorkListService;
import edu.kh.worklist.service.WorkListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			WorkListService service = new WorkListServiceImpl();
			
			Map<String, Object> map = service.workListFullView();
			
			// value가 Object 타입이라 다운캐스팅
			List<Work> workList = (List<Work>)map.get("workList");
			int completeCount = (int)map.get("completeCount");
			
			// 요청 객체에 값 저장
			req.setAttribute("workList", workList);
			req.setAttribute("completeCount", completeCount);
			
			// 해당 경로에 위에 값 위임
			String path = "/WEB-INF/views/main.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
