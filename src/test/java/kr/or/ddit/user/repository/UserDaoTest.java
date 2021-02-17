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
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserDaoTest {
	
	private UserDaoI userDao;
	
	//테스트에 사용할 신규 사용자 추가 
	// 모든 테스트 코드 실행 전에 테스트에 참여할 수 있는  임의의 사용자를 입력 

	@Before
	public void setup() {
		userDao = new UserDao();
		
		UserVo userVo = new UserVo("test","대덕인재","test", new Date(),
										   "개발원 m", "대전시 중구 중앙로76","4층 대덕인재개발원","34940","brown.png","uuid-generated-filename.png");
		userDao.registerUser(userVo);
		
		// 신규 입력 테스트를 위해 테스트 과정에서 입력된 데이터를 삭제 
		// "ddit_n"이라는 사용자는 무조건 삭제를 한다 
		userDao.deleteUser("ddit_n");
		
	}
	@After
	public void teadDown() {
		userDao.deleteUser("test");
	}
	
	
// 전체 사용자 조회 테스트 
	@Test
	public void test() {
		/*** Given ***/
//		UserDaoI userDao = new UserDao();

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
		String userid = "brown";
		
		/***When***/
		UserVo user = userDao.selectUser(userid);

		/***Then***/
		assertNotNull(user);
		assertEquals("브라운", user.getUsernm());
		
		
	}
	
	// 사용자 페이징 조회 테스트 
	@Test
	public void selectPaging() {
		
		/***Given***/
		
		UserServiceI userService = new UserService();
		PageVo pageVo = new PageVo(2, 5);
		
		/***When***/
		Map<String, Object> map = userService.selectPagingUser(pageVo);
		List<UserVo> pageList = (List<UserVo>)map.get("pageList");
		int userCnt = (int)map.get("userCnt");

		/***Then***/
		assertEquals(5, pageList.size());
		assertEquals(16, userCnt);
		
	}
	
	@Test
	public void selectAllUserCnt() {
		int userCnt = userDao.selectAllUserCnt();
		
		assertEquals(16, userCnt);
	}
	
	@Test
	public void modifyUserTest() {
		/*** Given ***/
//		UserDaoI userDao = new UserDao();
		
		//userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode
		UserVo userVo = new UserVo("ddit","대덕인재","dditpass", new Date(),
								   "개발원 m", "대전시 중구 중앙로76","4층 대덕인재개발원","34940","brown.png","uuid-generated-filename.png");
		
		/*** When ***/
		int updateCnt = userDao.modifyUser(userVo);
		
		/*** Then ***/
		assertEquals(1, updateCnt);
		
	}
	
	// 삭제 테스트
	@Test
	public void deleteUserTest() {
		/***Given***/
		// 해당 테스트가 실행 될 때는 testUser 라는 사용자가 before 메소드에 의해 등록이 된 상태 
		String userid = "test";
		
		/***When***/
		int delteCnt = userDao.deleteUser(userid);
		
		/***Then***/
		assertEquals(1, delteCnt);
	}


	
	
}
