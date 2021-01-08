package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
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
	public List<UserVo> selectPagingUser(PageVo pageVo) {
		// TODO Auto-generated method stub
		return dao.selectPagingUser(pageVo);
	}
	

}
