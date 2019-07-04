package cn.kgc.tangcco.dao.impl;

import java.sql.Connection;
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

	@Override
	public List<Role> queryRoleByUserId(String userId) {
		String sql="SELECT * FROM roles WHERE id IN ( SELECT role_id FROM userrole WHERE user_id = ? )";
		try {
			return qr.query(sql, new BeanListHandler<Role>(Role.class),userId);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int updateUserRole(String userId, String[] roleIds) {
		Connection connection;
	    connection =  JDBCUtils.getConnection();
	    try {
	        connection.setAutoCommit(false);     
	        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
	        //初始化QueryRunner时，构造方法不加入DataSource，调用update方法时必须传入connection对象
	        QueryRunner qr = new QueryRunner();
	        String sqldel = "delete from userrole where user_id=?";
	        qr.update(connection, sqldel, userId);
	        
	        for (int i = 0; i < roleIds.length; i++) {
	        	 String sqlinsert = "insert into userrole values(null,?,?)";
	        	 qr.update(connection, sqlinsert, userId,Integer.parseInt(roleIds[i]));
			}
	        connection.commit();
	        return 1;
	    } catch (SQLException e) {
	        try {
	            connection.rollback();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	        e.printStackTrace();
	    }finally {
	        try {
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return 0;

	}

}
