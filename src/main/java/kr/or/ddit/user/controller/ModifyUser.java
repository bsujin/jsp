package kr.or.ddit.user.controller;

import java.io.IOException;

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

@WebServlet("/userModify2")
public class ModifyUser extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(ModifyUser.class);
	private UserServiceI service = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//	1) userid 파라미터 확인
		String userid = req.getParameter("userid");
		
		//	2) userService를 이용하여 사용자 정보 조회
		UserVo vo = (UserVo)service.selectUser(userid);
		// 	3) request 객체에 user속성으로 설정
		req.setAttribute("user", vo);
		
		// 	4) webapp/user/userModify.jsp 로 forward
		req.getRequestDispatcher("/user/userModify.jsp").forward(req, resp);
	}
}
