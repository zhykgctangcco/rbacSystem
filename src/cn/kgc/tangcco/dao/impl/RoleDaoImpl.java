package cn.kgc.tangcco.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.kgc.tangcco.dao.RoleDao;
import cn.kgc.tangcco.entity.Role;
import cn.kgc.tangcco.util.JDBCUtils;

public class RoleDaoImpl implements RoleDao{
	private QueryRunner qr;
	public RoleDaoImpl() {
		qr=new QueryRunner(JDBCUtils.getDataSource());
	}

	@Override
	public List<Role> queryRoleList() {
		String sql="select * from roles ";
		try {
			return qr.query(sql, new BeanListHandler<Role>(Role.class));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
