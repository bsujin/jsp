package kr.or.ddit.servlet;

import java.io.IOException;
import java.util.Collection;
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
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet{

	// doGet : 파일 업로드를 테스트할 화면을 응답으로 생성
	// webapp/jsp/fileUpload.jsp --> 나는 webapp/jsp/file/fileUpload.jsp로 만듦
	private static final Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/jsp/file/fileUpload.jsp").forward(req, resp);
	}
	
	
	// doPost : 파일 업로드 화면에서 서버로 파일 업로드 요청
		// 요청 처리 후에 파일 업로드 화면으로 이동
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("contentType : {} ", req.getContentType());
		logger.debug("userid : {}", req.getParameter("userid"));
		logger.debug("file : {}", req.getParameter("file"));

		String userid = req.getParameter("userid");
		UserVo userVo = userService.selectUser(userid);

		String path = "";
		if(userVo.getFilename() == null) {
			path = getServletContext().getRealPath("/image/unknown.png");
		}else {
			path = "d:\\upload\\" + userVo.getRealfilename();
		}
		
		Part part = req.getPart("file");
		if(part.getSize() > 0) {
			//사용자가 업로드한 파일 이름
			String filename = FileUtil.getFileName(part.getHeader("ContentDispostion"));
			
			//서버에 저장할 때 다른 사용자의 파일과 중복되지 않도록 생성한 파일 이름
			String realFileName = UUID.randomUUID().toString();
			part.write("d:\\upload\\" + filename);
		}
		
		// 이름을 알면 여러개의 작업을 해야한다 - collection 사용하면 일괄적으로 작업하기 유용함 
		// 복수개의 파일을 업로드 하고 파트 이름을 모를 때 
		Collection<Part> parts = req.getParts();
		for(Part p : parts) {
			String filename = FileUtil.getFileName(p.getHeader("Content-Dispostion"));
			part.write("d:\\upload\\" + filename);
		}
		logger.debug("Content-Disposition : {} ", part.getHeader("Content-Dispostion"));
		
//		InputStreamReader isr = new InputStreamReader(req.getInputStream());
//		char[] buff = new char[512];
//		while(isr.read(buff) != -1) {
//			System.out.println(buff);
//		}
//		isr.close();
		doGet(req,resp);
	}
	
}
