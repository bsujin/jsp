package kr.or.ddit.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet{

		private static final Logger logger = LoggerFactory.getLogger(ProfileServlet.class);
		private UserServiceI userService = new UserService();
	
	// 링크를 보내주는것 - get방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// userid 파라미터를 이용하여 userService 객체를 통해 사용자의 사진 파일 이름을 획득
		String userid = req.getParameter("userid");
		UserVo userVo = userService.selectUser(userid);
		
		String path = "";
		if(userVo.getRealfilename() == null){
			path = getServletContext().getRealPath("/image/unknown.png");
		}else {
			path ="d:\\upload\\" + userVo.getRealfilename();
		}
			
		// 파일 입출력을 통해 사진을 읽어들여 response 객체의 ouputStream으로 응답을 생성한다
		logger.debug("path-profile{}" , path);
		
		FileInputStream fis = new FileInputStream(path);
		ServletOutputStream sos = resp.getOutputStream();

		byte[] buff = new byte[512];
		// buff사이즈만큼 읽어준다 - 더이상 읽을 데이터가 없을때까지 읽어줌 
		while(fis.read(buff) != -1) {
			sos.write(buff);
		}
		
		// 사용한 자원을 반납해준다 
		fis.close();
		sos.close();
	
	}

}
