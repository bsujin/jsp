package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class DefaultParameterRequestWrapper extends HttpServletRequestWrapper {
	private Map<String, String[]> customMap;

	public DefaultParameterRequestWrapper(HttpServletRequest request) {
		super(request);
		
		customMap = new HashMap<String, String[]>(request.getParameterMap());

		// 사정에 의해서 모든 요청객체에 UNT_CD 파라미터로 DDIT 문자열 값을 넣어줘야 되는 상황
		customMap.put("UNT_CD", new String[] {"DDIT"});

	}

	// 우리가 만든 MAP 객체를 사용할 수 있도록 재정의하기

	@Override
	public String getParameter(String name) {
		// 키에 해당하는 값중에 첫번째 값을 반환
		// 키에 해당하는 값이 없을때 ? ==> null 
		String[] values = customMap.get(name);
		if(values == null || values.length == 0) {
			return null;
		}else
			return values[0];
	}
	@Override
	public Map<String, String[]> getParameterMap() {
		return customMap;
	}
	@Override
	public Enumeration<String> getParameterNames() {
		// collection이 인자로 들어간다 - coollection(list, set) - map은 제외 
		// keySet을 사용 
		return Collections.enumeration(customMap.keySet());
	}

	// 특정 파라미터의 모든 값을 리턴해준다 -> map에 담겨져 있는 value를 넘겨주면 된다 
	@Override
	public String[] getParameterValues(String name) {
		// TODO Auto-generated method stub
		return customMap.get(name);
	}

}
