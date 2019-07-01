package cn.kgc.tangcco.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import cn.kgc.tangcco.dao.PrivilegeDao;
import cn.kgc.tangcco.entity.Privilege;
import cn.kgc.tangcco.util.JDBCUtils;

public class PrivilegeDaoImpl implements PrivilegeDao{
	private QueryRunner qr;
    public PrivilegeDaoImpl() {
    	qr=new QueryRunner(JDBCUtils.getDataSource());
	}
	@Override
	public List<Privilege> queryPrivilegeByUser(String userId) {
		String sql="SELECT\r\n" + 
				"	* \r\n" + 
				"FROM\r\n" + 
				"	`privileges` \r\n" + 
				"WHERE\r\n" + 
				"	id IN (\r\n" + 
				"	SELECT\r\n" + 
				"		privilege_id \r\n" + 
				"	FROM\r\n" + 
				"		roleprivilege \r\n" + 
				"	WHERE\r\n" + 
				"		role_id IN ( SELECT id FROM roles WHERE id IN ( SELECT role_id FROM userrole WHERE user_id = ? ) ) \r\n" + 
				"	)";
				try {
					List<Privilege> list=qr.query(sql, new BeanListHandler<Privilege>(Privilege.class),userId );
				    return list;
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
				
		
	}
	@Override
	public List<Privilege> queryPrivilegeByRole(int roleId) {
		String sql="SELECT\r\n" + 
				"	* \r\n" + 
				"FROM\r\n" + 
				"	`privileges` \r\n" + 
				"WHERE\r\n" + 
				"	id IN (\r\n" + 
				"	SELECT\r\n" + 
				"		privilege_id \r\n" + 
				"	FROM\r\n" + 
				"		roleprivilege \r\n" + 
				"	WHERE\r\n" + 
				"		role_id=? )";
		try {
			List<Privilege> list=qr.query(sql, new BeanListHandler<Privilege>(Privilege.class),roleId );
		    return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<Privilege> queryAllPrivilege() {
		String sql="SELECT * FROM `privileges`";
		try {
			List<Privilege> list=qr.query(sql, new BeanListHandler<Privilege>(Privilege.class) );
		    return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public int UpdateRolePrivilege(int roleId, String[] arr) {
		Connection connection;
	    connection =  JDBCUtils.getConnection();
	    try {
	        connection.setAutoCommit(false);     
	        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
	        //初始化QueryRunner时，构造方法不加入DataSource，调用update方法时必须传入connection对象
	        QueryRunner qr = new QueryRunner();
	        String sqldel = "delete from roleprivilege where role_id=?";
	        qr.update(connection, sqldel, roleId);
	        
	        for (int i = 0; i < arr.length; i++) {
	        	 String sqlinsert = "insert into roleprivilege values(null,?,?)";
	        	 qr.update(connection, sqlinsert, roleId,Integer.parseInt(arr[i]));
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
