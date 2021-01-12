package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/pagingUser1")
public class pagingUser1 extends HttpServlet {
	
	UserServiceI service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// request 객체에서 제공하는 파라미터 관련 메소드
		
//		Map<String, String> map = new HashMap<String, Strings>();
//		map.put("userid", "brown");
//		
//		map.get("pass");
//		map.getOrDefault(map, getServletInfo())
//		
		
		
		
		
		
		// left.jsp : /pagingUser?page=1&pageSize=5
		// ===> /pagingUser --> 값이 없을때로 바뀔 때 
		
		// doGet 메소드에서 page, pageSize 파라미터가 request 객체에 존재하지 않을 때 
		// page는 1로 pageSize는 5로 생각하여 코드 작성
		// 파라미터가 존재하면 해당 파라미터를 이용 
		
		// primitive Type 원시타입 ==> class(wrapper 클래스)
		int page = Integer.parseInt(req.getParameter("page"));
		int pageSize = Integer.parseInt(req.getParameter("pageSize"));

		PageVo vo;
		if(req.getParameter("page")==null||req.getParameter("pageSize")== null) {
			vo = new PageVo(1, 5);
		}else {
			vo = new PageVo(page, pageSize);
		}
//		List<UserVo> pageList = service.selectPagingUser(vo);
		
//		req.setAttribute("pageList",pageList);
//		req.setAttribute("userList",pageList);
		
		req.getRequestDispatcher("/user/pagingUser.jsp").forward(req, resp);
//		req.getRequestDispatcher("/user/allUser.jsp").forward(req, resp);
		
	
	
	
	}
}
