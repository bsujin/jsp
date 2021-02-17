package kr.or.ddit.user.respository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtill;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoI{
	
	@Override
	public List<UserVo> selectAllUser() {
		SqlSession sqlSession = MybatisUtill.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("users.selectAllUser");
		sqlSession.close();
		
		return userList;
	}

	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlSession = MybatisUtill.getSqlSession();
		UserVo user = sqlSession.selectOne("users.selectUser", userid);
		sqlSession.close();
		return user;
	}
	
	@Override
	public List<UserVo> selectPagingUser(PageVo vo) {
		SqlSession sqlSession = MybatisUtill.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("users.selectPagingUser", vo);
		sqlSession.close();
		
		return userList;
	}

	@Override
	public int selectAllUserCnt() {
		SqlSession sqlSession = MybatisUtill.getSqlSession();
		int userCnt = sqlSession.selectOne("users.selectAllUserCnt");
		sqlSession.close();
		return userCnt;
	}

	@Override
	public int modifyUser(UserVo userVo) {
		SqlSession sqlSession = MybatisUtill.getSqlSession();
		int updateCnt = sqlSession.update("users.modifyUser", userVo);
		
		if(updateCnt == 1) {
			sqlSession.commit();			
		}else{
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public int registerUser(UserVo userVo) {
		SqlSession sqlSession = MybatisUtill.getSqlSession();
		int updateCnt = sqlSession.update("users.registerUser", userVo);
		
		if(updateCnt == 1) {
			sqlSession.commit();			
		}else{
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public int deleteUser(String userid) {
		SqlSession sqlSession = MybatisUtill.getSqlSession();
		int deleteCnt = sqlSession.update("users.deleteUser", userid);
		
		if(deleteCnt == 1) {
			sqlSession.commit();			
		}else{
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return deleteCnt;
	}

	
	
}
