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


@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(BasicServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
//		int start = Integer.parseInt(req.getParameter("start"));
//		int end = Integer.parseInt(req.getParameter("end"));
		
//		if(start>=end) {
//			req.getRequestDispatcher("/jsp/sumCalculation.jsp").forward(req, resp);
//		}else if(start<end) {
			req.getRequestDispatcher("/jsp/sumResult.jsp").forward(req, resp);
//		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int start = Integer.parseInt(req.getParameter("start"));
		int end = Integer.parseInt(req.getParameter("end"));
		
//		if(start<end) {
		HttpSession session = req.getSession();
		
		int sum =0;
		for(int i=start; i<=end; i++) {
			sum += i;
		}
//		}
		session.setAttribute("sumResult", sum);
		
		req.setAttribute("start", start);
		req.setAttribute("end", end);
		
		logger.debug("start : {} , end : {},  두 숫자의 합 : {}", start, end, sum);
		
		req.getRequestDispatcher("/jsp/sumResult.jsp").forward(req, resp);
		
	}
}
