package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;
import kr.or.ddit.util.FileUtil;

@MultipartConfig
@WebServlet("/registUser")
public class registUser extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(registUser.class);
	private UserServiceI userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/user/registUser.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		logger.debug("doget진입");
		String userid = req.getParameter("userid");
		String usernm = req.getParameter("usernm");
		String pass = req.getParameter("pass");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date reg_dt = null;

		try {
			reg_dt = sdf.parse(req.getParameter("reg_dt"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String alias = req.getParameter("alias");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");

		// 사용자가 profile을 업로드 한 경우
		// 전송한 파일이름 (filename)
		// 서버에 저장할 파일이름(realfilename)
		// 파일 확장자
		Part profile = req.getPart("profile");
		String filename = "";
		String realFilename = "";
		if (profile.getSize() > 0) {
			// 파일 이름과 확장자를 가져오기
			filename = FileUtil.getFileName(profile.getHeader("Content-Disposition"));
			String fileExtension = FileUtil.getFileExtension(filename);

			// 파일확장자가 없는 경우는 상관 없으나 존재하면 toString 뒤에 확장자를 붙여줘야한다
			 realFilename = UUID.randomUUID().toString() + fileExtension;
			
			profile.write("d:\\upload\\" + realFilename);
		}
		// 서버에 지정된 공간에 저장

		UserVo userVo = new UserVo(userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode,filename,realFilename);

		// service에서 예외처리를 안해줬을 경우, servlet에서 처리
		int insertCnt = 0;

		try {
			// 예외 처리를 해줘야한다
			insertCnt = userService.registerUser(userVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (insertCnt == 1) {
			resp.sendRedirect(req.getContextPath() + "/pagingUser");
		} else {
			doGet(req, resp);
		}

	}
}