package cn.kgc.tangcco.dao;

import java.util.List;

import cn.kgc.tangcco.entity.User;

public interface UserDao {
	/**
	 * 用户登录  按邮箱和密码登录
	 * @param user 邮箱和密码
	 * @return  用户信息
	 */
   public  User  loginByEmailAndPwd(User user) ;
   
   public List<User> queryAllUser();
}
