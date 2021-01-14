package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserServiceI {

	List<UserVo> selectAllUser();
	
	UserVo selectUser(String userid);
	
	Map<String,Object> selectPagingUser(PageVo vo);
	
	//사용자 정보 수정
	int modifyUser(UserVo userVo);
	
	//사용자 신규 등록
	int registerUser(UserVo userVo);
	
	// 사용자 삭제 
	int deleteUser(String userid);
}
