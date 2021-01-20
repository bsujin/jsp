package kr.or.ddit.emp.repository;

import java.util.List;

import kr.or.ddit.emp.model.EmpVo;

public interface EmpDaoI {
	// emp 정보 가져오기
		List<EmpVo> selectAllempList();
		
}
