package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.nio.file.spi.FileSystemProvider;
import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class UserDaoTest {

// 전체 사용자 조회 테스트 
	@Test
	public void test() {
		/*** Given ***/
		UserDaoI userDao = new UserDao();

		/*** When ***/
		List<UserVo> userList = userDao.selectAllUser();

		/*** Then ***/
		assertEquals(16, userList.size());
		
	}

	//cf) JPA : find by id 
	
//사용자 아이디를 이용하여 특정 사용자 정보 조회
	//test메소드는 항상 public - 반환타입 void 이여야 한다 
	@Test
	public void selectUserTest() {
		
		/***Given***/
		UserDaoI userDao = new UserDao();
		String userid = "brown";
		
		/***When***/
		UserVo user = userDao.selectUser(userid);

		/***Then***/
		assertNotNull(user);
		assertEquals("브라운", user.getUsernm());
		
		
	}
	
	// 사용자 페이징 조회 테스트 
	@Test
	public void selectPagingUserTest() {
		/***Given***/
		UserDaoI userdao = new UserDao();
		PageVo pageVo = new PageVo(2,5);
		
		/***When***/
//		List<UserVo> pageList = userdao.selectPagingUser(page, pageSize);  --> 2개의 인자를 가져오면 에러 
		List<UserVo> pageList = userdao.selectPagingUser(pageVo);

		/***Then***/
		assertEquals(5, pageList.size());
	}
	
	@Test
	public void selectAllUserCnt() {
		/***Given***/
		UserDaoI userdao = new UserDao();

		/***When***/
		int userCnt = userdao.selectAllUserCount();
//		System.out.println(userCnt);
		
		/***Then***/
		assertEquals(16, userCnt);
	}

}
