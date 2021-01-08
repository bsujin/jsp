package kr.or.ddit.user.respository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtill;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoI {

	@Override
	public List<UserVo> selectAllUser() {

		// 사용하기 위해 MybatisUtill에서 static이 되어있는지 확인하기
		SqlSession sqlSession = MybatisUtill.getSqlSession();

		// select : 리턴되는 값의 복수 유무를 판단
		// 1. 단건 : 일반 객체를 반환 (UserVo) selectOne()
		// 2. 여러건 : List<UserVo> selectList()
		// insert, update, delete : 메소드 이름과 동일 (insert, update, delete)

		// 메소드 이름과 실행할 sql id를 동일하게 맞추자 ( 유지보수에 편함 - 다른 개발자의 가독성 )
		// namespace와 동일하게 가야한다
		List<UserVo> userList = sqlSession.selectList("users.selectAllUser");

		// mybatis framework에서 다르므로로 메소드만 사용하면 자원을 해제해준다
		sqlSession.close(); // 사용한 자원 반환

		return userList;
	}

	//userid에 해당하는 사용자 한명의 정보 조회 
	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlSession = MybatisUtill.getSqlSession();
		
//		select* from users where userid = 메서드로 들어온 인자 -> userid 넣어줘야 한다 
		//1건의 정보 조회
		UserVo user = sqlSession.selectOne("users.selectUser", userid);
		
		//sqlSession 객체는 사용후 자원 반환 해줘야 한다 
		sqlSession.close();
		
		return user;
	}

	// 페이지 처리 
	@Override
	public List<UserVo> selectPagingUser(PageVo pageVo) {
		SqlSession sqlSession = MybatisUtill.getSqlSession();
		
		List<UserVo> pageList = sqlSession.selectList("users.selectPagingUser", pageVo);
		
		sqlSession.close();
		
		return pageList;
	}


	// 페이지 처리 
//	@Override
//	public List<UserVo> selectPagingUser(int page, int pageSize) {
//
//		SqlSession sqlSession = MybatisUtill.getSqlSession();
//		
//		List<UserVo> pageList = sqlSession.selectList("users.selectPagingUser");
//		
//		sqlSession.close();
//		
//		return pageList;
//	}

	

}
