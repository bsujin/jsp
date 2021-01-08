package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserServiceI {
	
	//전체 정보 조회
	List<UserVo> selectAllUser();
	
	//userid에 해당하는 사용자 한명의 정보 조회 
	UserVo selectUser(String userid);
	
	//사용자 페이징 조회 - page처리 
	List<UserVo> selectPagingUser(PageVo pageVo);
	
}
