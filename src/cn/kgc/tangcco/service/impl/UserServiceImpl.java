package cn.kgc.tangcco.service.impl;

import java.util.List;

import cn.kgc.tangcco.dao.UserDao;
import cn.kgc.tangcco.entity.User;
import cn.kgc.tangcco.service.UserService;
import cn.kgc.tangcco.util.PropertiesFactory;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	public UserServiceImpl() {
		userDao = (UserDao) PropertiesFactory.getInstance("userDao");
	}
	@Override
	public User loginByEmailAndPwd(User user) {
		return userDao.loginByEmailAndPwd(user);
	}
	@Override
	public List<User> queryAllUser() {
		return userDao.queryAllUser();
	}

}
