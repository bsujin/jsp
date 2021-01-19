package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;

public class SessionCheckFilter implements Filter {
	
private static final Logger logger = LoggerFactory.getLogger(SessionCheckFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 요청 URI가 S_USER 속성이 세션이 있어야 하닌 주소인지 먼저 체크하기 
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();	//요청 uri 확인
		
		logger.debug("request uri : {}", uri);

		// 세션 체크가 필요없는 주소 : login.jsp, loginController 
		// 나머지의 정보들도 같이 보내줘야 한다 
//		if(uri.endsWith("login.jsp") || uri.endsWith("loginController") ||
//			uri.endsWith("css") || uri.endsWith("js") || uri.endsWith("png") || uri.endsWith("jpg")) {
			if(uri.endsWith("login.jsp") || uri.endsWith("loginController") ||
					uri.contains("/css/") || uri.contains("/js/") || uri.contains("/image/")) {
			chain.doFilter(request, response);  // 그냥 다음페이지로 넘어간다 
		}
		// 세션 체크가 필요 있는 주소 (S_USER 속성 확인) - 모르면 loginController에서 찾아보기 
		else {
			UserVo user =  (UserVo)req.getSession().getAttribute("S_USER");
			
			// user 정보가 null ==> 로그인을 안함 ==> 로그인 화면으로 이동
			if(user == null) {
				// forward는 문제가 될수 있다 - 메서드가 어떤거이냐에 따라 다름
				// redirect 사용 - 형변환 해줘야 한다 
				((HttpServletResponse)response).sendRedirect(req.getContextPath() + "/login.jsp");
			}
			// user 정보가 !null ==> 로그인 함  ==> 요청처리
			else {
				// 요청을 그대로 보내줌 
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
