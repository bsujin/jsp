package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestCounterFilter implements Filter {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestCounterFilter.class);
	
	// 요청을 받을 때마다 생성해줘야 하므로 전역변수로 선언해주기 
	Map<String, Integer> requestCountMap = new HashMap<String, Integer>();
	

	// 초기화  : 초기화 할때 값을 등록한다 
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("init()");
		ServletContext sc = filterConfig.getServletContext();
		sc.setAttribute("requestCountMap", requestCountMap);
	}
	
	// filter.doFilter == servlet.service
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("dofilter()");
		// request 객체를 이용하여 요청된 URI 정보를 카운팅
		// 그냥 req.getRequestURI() 를 사용하면 에러 - servletRequest 타입이라 형변환 해줘야한다
		
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();	//요청된 uri
		
		logger.debug("request uri : {}", uri);
		
		// requestCountMap 에 uri에 해당하는 키가 있을수도, 없을수도 있음 
		if(requestCountMap.get(uri) == null) {
			// 최초 요청시에는 존재하지 않아 값을 넣어준다 
			requestCountMap.put(uri, 1);
			logger.debug("최초요청 : {}",requestCountMap.get(uri) );
		}
		// 최초요청이 아닌 경우 - 과거에 이미 요청이 된 적이 있는 경우 
		// 값을 가져와서 1을 더해준다 
		else {
			int requestCount = requestCountMap.get(uri);
			requestCountMap.put(uri, requestCount + 1);
			logger.debug("최초가 아닌 요청 : {}",requestCountMap.get(uri) );
		}
		
		/*
		 * // application 스코프에 저장 : servletContext가 application ServletContext sc =
		 * req.getServletContext(); sc.setAttribute("requestCountMap", requestCountMap);
		 * 
		 * // 불필요한 코드 ==> 초기화( init에서 하면 된다 ) 메소드로 해당 로직 이관 
		 */	
		
		// 다른 필터가 있을 경우 필터로, 필터가 더이상 없을 경우 해당 요청을 처리하는 servlet, jsp(jsp는 jspServlet이 처리) 로 요청 위임
		// redirect 또는 forward 사용 - filterChain을 사용하면 된다
		chain.doFilter(request, response);
		
		
	}
	

	// 종료 
	@Override
	public void destroy() {

	}



}
