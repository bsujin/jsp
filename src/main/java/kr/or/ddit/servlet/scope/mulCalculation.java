package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.servlet.basic.BasicServlet;

@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(BasicServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/jsp/mulResult.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int start = Integer.parseInt(req.getParameter("param1"));
		int end = Integer.parseInt(req.getParameter("param2"));
		
		HttpSession session = req.getSession();
		int mul = start * end;
		session.setAttribute("mulResult", mul);
		
		req.setAttribute("param1", start);
		req.setAttribute("param2", end);
		
		logger.debug("start : {} , end : {},  두 숫자의 합 : {}", start, end, mul);
		
		req.getRequestDispatcher("/jsp/mulResult.jsp").forward(req, resp);
		
	}
}
