package kr.or.ddit.user.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class UserService implements UserServiceI {
	
	private UserDaoI dao = new UserDao();    

	public List<UserVo> selectAllUser() {
		
		return dao.selectAllUser();
	
	}
	public UserVo selectUser(String userid) {
		
		return dao.selectUser(userid);
	}

	@Override
	public Map<String, Object> selectPagingUser(PageVo vo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserVo> userList = (List<UserVo>) dao.selectPagingUser(vo);
		   
		int userCnt = dao.selectAllUserCnt();
		   
		map.put("userList", userList);
		map.put("userCnt", userCnt);
		   
		return map;
	}
	@Override
	public int modifyUser(UserVo userVo) {
		return dao.modifyUser(userVo);
	}
	@Override
	public int registerUser(UserVo userVo) {
		return dao.registerUser(userVo);
	}
	
	@Override
	public int deleteUser(String userid) {
		return dao.deleteUser(userid);
	}
	
}
