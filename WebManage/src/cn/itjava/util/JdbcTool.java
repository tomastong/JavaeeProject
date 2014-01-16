package cn.itjava.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class JdbcTool {
	
	/**
	 * 功能：获取连接
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	/**
	 * 功能：关闭资源
	 * @param rs  
	 * @param ps
	 * @param conn
	 */
	public static void free(ResultSet rs, PreparedStatement ps, Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Oracle数据库连接字符串
	 */
	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	/**
	 * 数据库访问账号
	 */
	private static String username = "scott";
	/**
	 * 数据库访问密码
	 */
	private static String password = "tiger";
}
