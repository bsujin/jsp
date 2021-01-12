package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.model.UserVo;

public interface UserServiceI {
	
	//전체 정보 조회
	List<UserVo> selectAllUser();
	
	//userid에 해당하는 사용자 한명의 정보 조회 
	UserVo selectUser(String userid);
	
	//사용자 페이징 조회 - page처리 -> 두개의 select를 합치기 
//	int selectAlluserCnt(PageVo vo);
//	List<UserVo> selectPagingUser(PageVo pageVo);
	Map<String, Object>  selectPagingUser(PageVo pageVo);
	
	// emp 정보 가져오기
	List<EmpVo> selectAllempList();

	
}
