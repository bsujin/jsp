package kr.or.ddit.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 속성을 하나 더 하기위해 작업 
@WebServlet(value="/initDBCP", loadOnStartup = 1)
public class InitDBCP extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(InitDBCP.class);
	
	@Override
	public void init() throws ServletException {
		logger.debug("InitDBCP.init()");
	

	// 우리가 미리 만들어 놓은 커넥션 풀에 접속 -> 참조할 수 있는 무언가가 있어야한다
	// connection Pool 생성		-- 거의 생성할 일이 없다 프레임워크에서 생성하는 방법 제시함  
	BasicDataSource bs = new BasicDataSource();
	
	// 데이터 베이스에 연결 
	bs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	bs.setUsername("sem");
	bs.setPassword("java");
	bs.setUrl("jdbc:oracle:thin:@localhost");
	bs.setInitialSize(20);	
	
	// application scope에 connection Pool 저장
	// application 타입 : servlet Context
	ServletContext sc = getServletContext();
	
	
	// dbcp.jsp에서는 application scope에 저장된 커넥션풀을 사용하여 커넥션 객체를 얻고, 해제하는 과정을 반복 - 시간체크 
		sc.setAttribute("bs",bs);

	}
}
