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

@WebServlet("/profileDownload")
public class ProfileDownloadServlet extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(ProfileDownloadServlet.class);
	private UserServiceI userService = new UserService();

	// 링크를 보내주는것 - get방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// contentType을 설정 - 라이브러리 중에 파일 이름을 입력받아서 확장자에 맞게 contentType를 만들어주는 것이 있다
//		resp.setContentType("image");

		// userid 파라미터를 이용하여 userService 객체를 통해 사용자의 사진 파일 이름을 획득
		String userid = req.getParameter("userid");
		UserVo userVo = userService.selectUser(userid);

		// header 정보 추가 (Content-Disposition- header 정보) 
		resp.setHeader("Content-Disposition", "attachment; filename=" + userVo.getFilename());

		// 파일 입출력을 통해 사진을 읽어들여 response 객체의 ouputStream으로 응답을 생성한다
		String path = "";
		if (userVo.getRealfilename() == null) {
//			path = getServletContext().getRealPath("/image/unknown.png");
			path = getServletContext().getRealPath("/image/unknown.png");
		} else {
			path = "d:\\upload\\" + userVo.getRealfilename();
		}
//		String path ="d:\\upload\\" + userVo.getRealfilename();
		logger.debug("Down - path{}", path);
//		
		FileInputStream fis = new FileInputStream(path);
		ServletOutputStream sos = resp.getOutputStream();

		byte[] buff = new byte[512];
		// buff사이즈만큼 읽어준다 - 더이상 읽을 데이터가 없을때까지 읽어줌
		while (fis.read(buff) != -1) {
			sos.write(buff);
		}

		// 사용한 자원을 반납해준다
		fis.close();
		sos.close();

	}

}
