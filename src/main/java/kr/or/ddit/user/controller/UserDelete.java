package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/deleteUser")
public class UserDelete extends HttpServlet{

	// 요청을 처리하기 위해서 service 객체가 필요, logger 선언
	private static final Logger logger = LoggerFactory.getLogger(UserDelete.class);
	private UserServiceI userService = new UserService();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	delete users where userid = "파라미터로 받은 사용자 아이디 " --> 서버에 변화가 있으면 post 방식으로 보낸다
		String userid = req.getParameter("userid");
		
		int deleteCnt =0;
		try {
		
			// userid는 pk 키므로 하나만 삭제되면 정상적, 그렇지 않으면 비정상적
			deleteCnt = userService.deleteUser(userid);
		}catch (Exception e) {
			deleteCnt = 1;
		}
		if(deleteCnt ==1 ) {
			resp.sendRedirect(req.getContextPath() + "/pagingUser");
		}else {
			resp.sendRedirect(req.getContextPath() + "/user?userid=" + userid);
		}

	}

}
