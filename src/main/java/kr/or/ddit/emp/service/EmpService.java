package kr.or.ddit.emp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtill;
import kr.or.ddit.emp.model.EmpVo;

public class EmpService implements EmpServiceI {

	// emp List 가져오기 
	@Override
	public List<EmpVo> selectAllempList() {
		SqlSession sqlSession = MybatisUtill.getSqlSession();
		
		List<EmpVo> empList = sqlSession.selectList("emp.selectAllEmpList");
		
		sqlSession.close();
		
		return empList;
	}
	
	
}
