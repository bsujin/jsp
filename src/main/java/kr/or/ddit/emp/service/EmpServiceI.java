package kr.or.ddit.emp.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.user.model.UserVo;

public interface EmpServiceI {

	// emp 정보 가져오기
			List<EmpVo> selectAllempList();
}
