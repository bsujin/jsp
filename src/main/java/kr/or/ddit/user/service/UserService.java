package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.EmpVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class UserService implements UserServiceI{

	private UserDaoI dao = new UserDao();
	
	@Override
	public List<UserVo> selectAllUser() {
		return dao.selectAllUser();
	}

	@Override
	public UserVo selectUser(String userid) {
		// TODO Auto-generated method stub
		return dao.selectUser(userid);
	}

	@Override
	public Map<String, Object> selectPagingUser(PageVo pageVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserVo> userList = dao.selectPagingUser(pageVo);
		int userCnt = dao.selectAllUserCount();
		
		map.put("userList", userList);
		map.put("cnt", userCnt);
		
		return map;
	}

	@Override
	public List<EmpVo> selectAllempList() {
		return dao.selectAllempList();
	}


}
