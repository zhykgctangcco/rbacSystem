package cn.kgc.tangcco.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	
	private static DataSource dataSource;
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	
	public  static DataSource getDataSource() {
		return dataSource;
	}
	
	
	public static Connection getConnection() {
		Connection conn = null;
		conn = tl.get();
		
		if(conn==null) {
			try {
				conn = dataSource.getConnection();
				tl.set(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
