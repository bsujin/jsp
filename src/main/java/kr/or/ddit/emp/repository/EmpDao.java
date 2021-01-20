package kr.or.ddit.emp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtill;
import kr.or.ddit.emp.model.EmpVo;

public class EmpDao implements EmpDaoI {

	// emp List 가져오기 
	@Override
	public List<EmpVo> selectAllempList() {
		SqlSession sqlSession = MybatisUtill.getSqlSession();
		
		List<EmpVo> empList = sqlSession.selectList("emp.selectAllEmpList");
		
		sqlSession.close();
		
		return empList;
	}
}
