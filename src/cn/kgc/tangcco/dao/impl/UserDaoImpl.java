package cn.kgc.tangcco.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.kgc.tangcco.dao.UserDao;
import cn.kgc.tangcco.entity.User;
import cn.kgc.tangcco.util.JDBCUtils;

public class UserDaoImpl implements UserDao{
	private QueryRunner qr;
	public UserDaoImpl() {
		qr=new QueryRunner(JDBCUtils.getDataSource());
	}
	
	@Override
	public User loginByEmailAndPwd(User user) {
		String sql="select  * from   users  where email=? and `password`=?";
		try {
			user=qr.query(sql, new BeanHandler<User>(User.class), user.getEmail(),user.getPassword());
		    return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> queryAllUser() {
		String sql="select  * from   users ";
		try {
			return (List<User>) qr.query(sql, new BeanListHandler<User>(User.class));
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
