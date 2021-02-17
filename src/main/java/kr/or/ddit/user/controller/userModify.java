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
@WebServlet("/userModify")
public class userModify extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(userModify.class);
   private UserServiceI userService = new UserService();
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      String userid = req.getParameter("userid");
      
      UserVo user = userService.selectUser(userid);
      
      req.setAttribute("user", user);
      
      req.getRequestDispatcher("/user/userModify.jsp").forward(req, resp);
   }
   
   // 사용자 정보 수정 요청 처리
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
      req.setCharacterEncoding("utf-8");	   // 파라미터를 읽기 전에 실행 , servlet의 doPost 메소드 마다 실행 필요 ==> Filter
      
      String userid = req.getParameter("userid");
      String usernm = req.getParameter("usernm");
      String pass = req.getParameter("pass");
      logger.debug("! reg_dt start" );
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
      Date reg_dt = null;
      logger.debug("! reg_dt {}",req.getParameter("reg_dt") );
      
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
   			
   			 // 서버에 지정된 공간에 저장
   			profile.write("d:\\upload\\" + realFilename);
   		}
//   		if(filename==getFile && realFilename==getReFile) {
   		else {
   		 UserVo user = userService.selectUser(userid);
         filename = user.getFilename();
         realFilename = user.getRealfilename();
         
   		}

   		UserVo userVo = new UserVo(userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode,filename,realFilename);
      
      int updateCnt = userService.modifyUser(userVo);
      
      if(updateCnt == 1) {	  // 수정이 정상적으로 된 경우 => 해당 사용자의 상세조회 페이지로 이동
         
         resp.sendRedirect(req.getContextPath()+"/user?userid="+userid);

      } else {  			 // 수정이 비정상적으로 된 경우 => 해당 사용자의 정보 수정 페이지로 이동
         doGet(req, resp);
      }    
   }
}