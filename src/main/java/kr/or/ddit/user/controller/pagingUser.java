package kr.or.ddit.user.controller;

import java.io.IOException;
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

@WebServlet("/pagingUser")
public class pagingUser extends HttpServlet {
	
	private UserServiceI service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// left.jsp " 
		// ===> pagingUser
		
		// doGet 메소드에서 page, pageSize 파라미터가 request 객체에 존재하지 않을 때 
		// page는 1로 pageSize는 5로 생각하여 코드 작성
		// 파라미터가 존재하면 해당 파라미터를 이용 
		
		// primitive Type 원시타입 ==> class(wrapper 클래스)

		//	if/ else ==> 조건 ? true일대 반환할 값 : false 일때 반환할 값 
		// refactoring : 코드를 깔끔하게 바꾸는데 기존 동작 방식을 유지한 채로 변경하는 기봅
	
//		int page = req.getParameter("page") == null? 1: Integer.parseInt(req.getParameter("page"));
//		int pageSize = req.getParameter("pageSize") == null? 5: Integer.parseInt(req.getParameter("pageSize"));
	
		// refactoring 하기
		String pageParam = req.getParameter("page");
		String pageSizeParam = req.getParameter("pageSize");
		
		int page = pageParam  == null? 1: Integer.parseInt(req.getParameter("page"));
		int pageSize = pageSizeParam == null? 5: Integer.parseInt(req.getParameter("pageSize"));
		
		PageVo vo = new PageVo(page, pageSize);
			
//		List<UserVo> pageList = service.selectPagingUser(vo);
		Map<String, Object> map = service.selectPagingUser(vo);
		List<UserVo> pageList = (List<UserVo>)map.get("userList");
		int userCnt = (int)map.get("cnt");
		// 페이징 계산 
		int pagination = (int)Math.ceil((double)userCnt/ pageSize);   //숫자 4라는 값을 만들어 낼 수 있다 
		
		req.setAttribute("pageList",pageList);
		
		// 4라는 값을 만들어서 넣어주기 
		req.setAttribute("pagination", pagination);
		
		// 현재의 페이지를 나타내기 위한 pageVo를 넣어준다 - 속성값 
		req.setAttribute("pageVo", vo);
		
		req.getRequestDispatcher("/user/pagingUser.jsp").forward(req, resp);
//		req.getRequestDispatcher("/user/allUser.jsp").forward(req, resp);
		
	
	
	
	}
}
