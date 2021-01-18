package kr.or.ddit.filter;

import java.util.HashMap;
import java.util.Map;

public class test {
public static void main(String[] args) {
	Map<String, String> map = new HashMap<>();
	map.put("userid", "brown");
	
	Map<String,String> otherMap = map;
	otherMap.put("userid","sally");
	
	System.out.println(map.get("userid"));
	
	// 동치, 동일
	// 동일이면 동치인가??  o   //  동치 이면 동일인가?? x
	// 객체 동일 비교 
	System.out.println(map == otherMap);
	
	Map<String, String> anotherMap = new HashMap<String, String>();
	anotherMap.put("userid", "sally");
	System.out.println(map == anotherMap);

	// 서로 다른 공간에 있지만 값은 같다 
	System.out.println(map.equals(anotherMap));
}
}
