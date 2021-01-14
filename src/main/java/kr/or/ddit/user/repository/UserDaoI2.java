package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.model.UserVo;

public interface UserDaoI2 {
	
	/* 
	   SELECT *
	   FROM user;
	 */

	//인터페이스는 자동으로 public이 붙는다 - public 안써줘도됨
	// 반환타입 메소드명();

	// 전체 사용자 정보 조회
	List<UserVo> selectAllUser();
	
	//userid에 해당하는 사용자 한명의 정보 조회 
	UserVo selectUser(String userid);
	
	//사용자 페이징 조회 - page처리 
//	List<UserVo> selectPagingUser(int page, int pageSize);
	List<UserVo> selectPagingUser(PageVo pageVo);
	
	// emp 정보 가져오기
	List<EmpVo> selectAllempList();
	
	// 사용자 전체 수 조회
	int selectAllUserCount();

	int modifyUser(UserVo userVo);
	
	// 사용자 삭제 
	int deleteUser(String userid);
}
