package kr.or.ddit.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;

public class LoginUserListener implements HttpSessionAttributeListener{
	private static final Logger logger = LoggerFactory.getLogger(LoginUserListener.class);
	private Set<String> users = new HashSet<String>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		
		if(event.getName().equals("S_USER")) {
			//속성 이름이 S_USER 이면
			UserVo user =(UserVo)event.getValue();
			logger.debug("added user : {} ", user.getUsernm());
			users.add(user.getUsernm());
			
			event.getSession().setAttribute("USER_SET", users);
		}

	}

	// 로그아웃한 사용자 삭제하기 
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		UserVo user = (UserVo)event.getValue();
		logger.debug("removed user : {}", user.getUsernm());
		users.remove(user.getUsernm());

//		event.getSession().setAttribute("USER_SET", users);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

}
