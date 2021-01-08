package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserServiceTest {

	//전체 사용자 가져오기 
	@Test
	public void test() {
		/*** Given ***/
		UserServiceI userService = new UserService();

		/*** When ***/
		List<UserVo> userList = userService.selectAllUser();

		/*** Then ***/
		assertEquals(16, userList.size());
		
	}
	
	// 사용자 아이디를 이용하여 특정 사용자 정보 조회 
	@Test
	public void selectUser() {
		/***Given***/
		UserServiceI userService = new UserService();
		String userid = "moon";
		
		/***When***/
		UserVo user = userService.selectUser(userid);

		/***Then***/
		assertNotNull(userid);
		assertEquals("문", user.getUsernm());
	}
	
	// 사용자 아이디가 존재하지 않을 때, 특정 사용자 조회 
	
	@Test
	public void selectUserNotExsistTest() {
		/***Given***/
		UserServiceI userService = new UserService();
		String userid = "sansd";
		
		/***When***/
		UserVo user = userService.selectUser(userid);

		/***Then***/
		assertNull(userid);
		
	}
	
	
	
	
	@Test
	public void selectPaging() {
		
		/***Given***/
		
		UserServiceI userService = new UserService();
		PageVo pageVo = new PageVo(2, 5);
		
		/***When***/
		List<UserVo> pageList = userService.selectPagingUser(pageVo);

		/***Then***/
		assertEquals(5, pageList.size());
		
	}
	
	
	

}
