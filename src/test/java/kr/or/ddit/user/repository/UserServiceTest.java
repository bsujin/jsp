package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserServiceTest {

	private UserServiceI userService;

	@Before
	public void setup() {
		userService = new UserService();

		// 테스트에 사용할 신규 사용자 추가
		UserVo userVo = new UserVo("test", "대덕인재", "test", new Date(), "개발원 m", "대전시 중구 중앙로76", "4층 대덕인재개발원", "34940");
		userService.registerUser(userVo);

		// 신규 입력 테스트를 위해 테스트 과정에서 입력된 데이터를 삭제 
		// "ddit_n"이라는 사용자는 무조건 삭제를 한다 
		userService.deleteUser("ddit_n");
	}
	
	@After
	public void teadDown() {
		userService.deleteUser("test");
	}
	

	// 전체 사용자 가져오기
	@Test
	public void test() {
		/*** Given ***/
		UserServiceI userService = new UserService();

		/*** When ***/
		List<UserVo> userList = userService.selectAllUser();

		/*** Then ***/
		assertEquals(14, userList.size());

	}

	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectUser() {
		/*** Given ***/
		UserServiceI userService = new UserService();
		String userid = "moon";

		/*** When ***/
		UserVo user = userService.selectUser(userid);

		/*** Then ***/
		assertNotNull(userid);
		assertEquals("문", user.getUsernm());
	}

	// 사용자 아이디가 존재하지 않을 때, 특정 사용자 조회

	@Test
	public void selectUserNotExsistTest() {
		/*** Given ***/
		UserServiceI userService = new UserService();
		String userid = "sansd";

		/*** When ***/
		UserVo user = userService.selectUser(userid);

		/*** Then ***/
		assertNotNull(userid);
//		assertNotEquals("문", user.getUsernm());

	}

	@Test
	public void selectPaging() {

		/*** Given ***/

		UserServiceI userService = new UserService();
		PageVo pageVo = new PageVo(2, 5);

		/*** When ***/
		Map<String, Object> map = userService.selectPagingUser(pageVo);
		List<UserVo> pageList = (List<UserVo>) map.get("userList");
		int userCnt = (int) map.get("userCnt");

		/*** Then ***/
		assertEquals(5, pageList.size());
		assertEquals(14, userCnt);

	}
	
	// 삭제 테스트
		@Test
		public void deleteUserTest() {
			/***Given***/
			// 해당 테스트가 실행 될 때는 testUser 라는 사용자가 before 메소드에 의해 등록이 된 상태 
			String userid = "test";
			
			/***When***/
			int delteCnt = userService.deleteUser(userid);
			
			/***Then***/
			assertEquals(1, delteCnt);
		}


}
