package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/allUser")
public class AllUser extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(AllUser.class);
	private UserServiceI service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * 1. service 객체를 통해 전체 사용자 정보를 조회 
		 * 2. request객체에 userList라는 속성명으로 1번에서 조회한 데이터를 설정 
		 * 3. webapp/user/allUser.jsp로 응답을 생성하도록 forward allUser.jsp에서는 user.html을
		 * 참고하여 생성 header.jsp, left.jsp 를 재활용하여 생성
		 */
		
		List<UserVo> userList = service.selectAllUser();
		req.setAttribute("userlist", userList);
		req.getRequestDispatcher("/user/allUser.jsp").forward(req, resp);
		

	}
	
}
